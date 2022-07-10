package tech.sushnag22.attendancemanager.models;

public class Student {

    private String student_usn;
    private String student_firstname;
    private String student_lastname;
    private String student_mobile_number;
    private String student_email;
    private String student_branch;
    private String student_sem;

    public String getStudent_usn() {
        return student_usn;
    }

    public void setStudent_usn(String student_usn) {
        this.student_usn = student_usn;
    }

    public String getStudent_firstname() {
        return student_firstname;
    }

    public void setStudent_firstname(String student_firstname) {
        this.student_firstname = student_firstname;
    }

    public String getStudent_lastname() {
        return student_lastname;
    }

    public void setStudent_lastname(String student_lastname) {
        this.student_lastname = student_lastname;
    }

    public String getStudent_mobile_number() {
        return student_mobile_number;
    }

    public void setStudent_mobile_number(String student_mobile_number) {
        this.student_mobile_number = student_mobile_number;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_branch() {
        return student_branch;
    }

    public void setStudent_branch(String student_branch) {
        this.student_branch = student_branch;
    }

    public String getStudent_sem() {
        return student_sem;
    }

    public void setStudent_sem(String student_sem) {
        this.student_sem = student_sem;
    }
}
