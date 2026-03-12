


package model;

public class Student {
    private int studentId;
    private String studentName;
    private String email;
    private String password;

    public Student(int studentId, String studentName, String email, String password) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.password = password;
    }

    public int getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}