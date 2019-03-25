
/**
 * Class designed to generate object that contain relevan information to the problem.
 *
 * @author Isabel Piedrahita.
 * @version 24/03/2019
 */
public class Student
{
    private String code;
    private String semester;
    private String grade;
    private String subject;
    
    public Student(String code, String semester, String grade) {
        this.code = code;
        this.semester = semester;
        this.grade = grade;
    }
    
    public Student(String code, String semester, String grade, String subject) {
        this.code = code;
        this.semester = semester;
        this.grade = grade;
        this.subject = subject;
    }
    
    public void print() {
        System.out.println(this.code + " " + this.semester + " " + this.grade);
    }
    
    public void printWithSubject(){
        System.out.println(this.code + " " + this.semester + " " + this.grade + " " + this.subject);
    }
    
    public String getSemester() {
        return this.semester;
    }
    
    public String getCode() {
        return this.code;
    }
}
