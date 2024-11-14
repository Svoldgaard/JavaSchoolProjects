package be;

public class GradeInfo {
    private String subject;
    private int Grade;

    public GradeInfo (String subject, int grade) {
        this.subject = subject;
        this.Grade = grade;
    }

    public String getSubject() {
        return subject;

    }

    public int getGrade() {
        return Grade;
    }

    @Override
    public String toString() {
        return "subject=" + subject + ", grade=" + Grade;
    }
}
