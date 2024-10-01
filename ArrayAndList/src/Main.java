import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        //int[] arrInt = {40,55,63,17,22,68,89,97,89};

        //System.out.println(arrInt[3] + arrInt[4]);
        //System.out.println(arrInt[2]);
        //funWithClassesAndArraysAndForeEachLoops();

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Willy"));

        System.out.println("arr size: " + students.size());

        students.add(new Student("Wonka"));
        students.add(new Student("Jeppe"));

        for (Student student : students) {
            System.out.println(student.getName());

        }

        Student stud = students.get(0);
        System.out.println("Student nr. 0 = " + stud.getName());

        System.out.println("REMOVING ELEMENT");
        students.remove(1);
        System.out.println("Arr size: " + students.size());

        for (Student student : students) {
            System.out.println(student.getName());

        }
    }

    public static void funWithClassesAndArraysAndForeEachLoops(){

        Student[] students = new Student [3];

        students[0] = new Student("David larry");
        students[1] = new Student("Luke Perry");
        students[2] = new Student("the platypus, Perry");

        for (Student oneOfTheStudents : students){
            System.out.println(oneOfTheStudents.getName());
        }
    }
}

