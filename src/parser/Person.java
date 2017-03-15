package parser;


import java.time.LocalDate;

public class Person {
    private int id;
    private String fname;
    private String lname;
    private Integer age;
    private LocalDate bday;
    private String role;
    private Status status;

    public Person() {}

    public Person(int id, String fname, String lname, Integer age, LocalDate bday, String role, Status status) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.bday = bday;
        this.role = role;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBday() {
        return bday;
    }

    public void setBday(LocalDate bday) {
        this.bday = bday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
