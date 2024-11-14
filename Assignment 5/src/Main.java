import be.GradeInfo;
import be.Person;
import be.Student;
import be.Teacher;

import java.util.ArrayList;
import java.util.List;

public void main() {
}
public static void main(String[] args) {


    personTest();

}

public static void personTest() {

    List<Person> persons = new ArrayList<>();

    //persons
    Person p1 = new Person(100, "Hans Nielsen");
    p1.setEmail("hni@easv.dk");
    persons.add(p1);

    Person p2 = new Person(101, "Niels Hansen");
    p2.setEmail("nha@easv.dk");
    persons.add(p2);

    Person p3 = new Person(102, "Ib Boesen");
    p3.setEmail("ibo@easv.dk");
    persons.add(p3);


    //teachers
    Teacher t1 = new Teacher(200, "Bent h. Pedersen", "bhp");
    t1.setEmail("bhp@easv.dk");
    persons.add(t1);

    Teacher t2 = new Teacher(201, "Orla Knudsen", "olk");
    t2.setEmail("olk@easv.dk");
    persons.add(t2);

    Teacher t3 = new Teacher(202, "Kent Hansen", "kth");
    t2.setEmail("kth@easv.dk");
    persons.add(t3);


    //Students
    Student s1 = new Student(300, "Bo Ibsen", "CS");
    s1.setEmail("bib@easv.dk");
    s1.addGrade(new GradeInfo("SCO1", 10));
    s1.addGrade(new GradeInfo("SCO2", 7));
    persons.add(s1);

    Student s2 = new Student(301, "Carsten Ovesen", "CS");
    s2.setEmail("cao@easv.dk");
    s2.addGrade(new GradeInfo("SCO1", 2));
    s2.addGrade(new GradeInfo("SCO2", 4));
    persons.add(s2);

    Student s3 = new Student(302, "Louise Larsen", "CS");
    s3.setEmail("LOL@easv.dk");
    s3.addGrade(new GradeInfo("SCO1", 12));
    s3.addGrade(new GradeInfo("SCO2", 12));
    persons.add(s3);


    for (Person p : persons) {
        System.out.println(p);

    }
}