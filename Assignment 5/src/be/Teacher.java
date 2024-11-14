package be;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<String> subjects = new ArrayList<>();
    private String initials;
    private double salary;


    public Teacher(int id, String name, String initials) {
        super(id, name);
        this.initials = initials;
        this.subjects.add(initials);
        this.salary = 0.0;

    }

    public List<String> getSubjects() {
        return subjects;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setSalary(double Salary) {
        this.salary = Salary;

    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Email: " + email + " Initials: " + initials;
    }

}
