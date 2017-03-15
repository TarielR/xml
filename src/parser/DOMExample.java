package parser;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class DOMExample implements ParserExample {

    private final DocumentBuilderFactory docFactory;
    private Document doc;
    private DocumentBuilder docBuilder;
    private File file;

    public DOMExample(String fileName) {
        file = new File(fileName);
        docFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document createDoc(Person p) {

        doc = docBuilder.newDocument();

        Element root = doc.createElement("root");
        doc.appendChild(root);

        Element list = doc.createElement("list");
        root.appendChild(list);

        Element person = doc.createElement("person");
        list.appendChild(person);

        Attr attrid = doc.createAttribute("id");
        attrid.setValue(String.valueOf(p.getId()));
        person.setAttributeNode(attrid);

        Attr attrst = doc.createAttribute("status");
        attrst.setTextContent(String.valueOf(p.getStatus()));
        person.setAttributeNode(attrst);

        Element fname = doc.createElement("fname");
        fname.setTextContent(p.getFname());
        person.appendChild(fname);

        Element lname = doc.createElement("lname");
        lname.setTextContent(p.getLname());
        person.appendChild(lname);

        Element age = doc.createElement("age");
        age.setTextContent(String.valueOf(p.getAge()));
        person.appendChild(age);

        Element bday = doc.createElement("bday");
        bday.setTextContent(String.valueOf(p.getBday()));
        person.appendChild(bday);

        Element role = doc.createElement("role");
        role.setTextContent(p.getRole());
        person.appendChild(role);

        return doc;
    }

    @Override
    public Document insertNode(Person person) {

        return null;
    }

    @Override
    public void writeFile(Document doc, File file) {

        Transformer trans = null;

        try {
            trans = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        DOMSource source = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(file);

        StreamResult result = new StreamResult(System.out);

        try {
            trans.transform(source, streamResult);
            trans.transform(source, result);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("Документ сохранен!");
    }

    @Override
    public void readFile() {
        try {
            doc = docBuilder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();
        System.out.println(doc.getDocumentElement().getTagName());

        if (doc.hasChildNodes())
            printNodes(doc.getChildNodes());
    }

    private void printNodes(NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);

            if (Node.ELEMENT_NODE == node.getNodeType()) {
                if (false)
                    System.out.println(node.getNodeName() + "<> ");
                else
                    System.out.println(node.getNodeName() + ": " + node.getTextContent());

                if (node.hasAttributes()) {
                    // Есть атрибуты: печатаем и их
                    NamedNodeMap attributes = node.getAttributes();
                    for (int j = 0; j < attributes.getLength(); j++) {
                        Node attribute = attributes.item(j);
                        System.out.println(attribute.getNodeName() + ": " + attribute.getNodeValue());
                    }
                }

                if (node.hasChildNodes())
                    printNodes(node.getChildNodes());
            }
        }
    }
}
