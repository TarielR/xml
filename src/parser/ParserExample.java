package parser;

import org.w3c.dom.Document;

import java.io.File;

public interface ParserExample {
    Document createDoc(Person person);
    Document insertNode(Person person);
    void writeFile(Document doc, File file);
    void readFile();
}
