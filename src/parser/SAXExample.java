package parser;


import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SAXExample {
    private static final String FILENAME = "SAXExample.xml";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        File input = new File(FILENAME);

        try {
            SAXParser parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        DefaultHandler handler = new MyHandler();


    }
}
