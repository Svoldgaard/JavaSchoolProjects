package be;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<GradeInfo> gradeRaport = new ArrayList<>();
    private String education;


    public Student(int id, String name, String education) {

        super(id, name);
        this.education = education;
        gradeRaport = new ArrayList<>();


    }

    public List<GradeInfo> getGradeRaport(){
        return gradeRaport;

    }

    public String getEducation() {
        return education;
    }

    private double getAverageGrade() {

        double avg = 0.0;
        double sum = 0.0;

        for(GradeInfo gradeInfo : gradeRaport){
            sum += gradeInfo.getGrade();
        }
        avg = sum / gradeRaport.size();
        return avg;


    }

    public int getGrade(String subject) {

        for(GradeInfo gradeInfo : gradeRaport){
            if(subject.equalsIgnoreCase(gradeInfo.getSubject())){
                return gradeInfo.getGrade();
            }
        }
        return -1;
    }
    public void addGrade(GradeInfo grade) {
        gradeRaport.add(grade);
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name + " Email: " + email + " Education: " + education + "Grade: " + getAverageGrade();
    }

}
