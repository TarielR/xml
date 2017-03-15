package parser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILENAME = "DOMExample.xml";
    private static List<Person> list = new ArrayList();

    public static void main(String[] args) {
        list.add(new Person(001, "Peter", "Gor", 22, LocalDate.parse("1966-08-12"), "manager", Status.PERMANENT));
        list.add(new Person(002, "Миша", "Волков", 33, LocalDate.parse("1986-02-02"), "friend", Status.TEMPORARY));
        list.add(new Person(003, "Kate", "Sierra", 44, LocalDate.parse("1999-01-30"), "director", Status.PERMANENT));

        DOMExample domExample = new DOMExample(FILENAME);

        domExample.readFile();

        for (Person p : list) {

        }
    }
}