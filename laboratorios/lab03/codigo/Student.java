
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
    
    public Student(String code, String semester, String grade) {
        this.code = code;
        this.semester = semester;
        this.grade = grade;
    }
    
    public void print() {
        System.out.println(this.code + " " + this.semester + " " + this.grade);
    }
    
    public String getSemester() {
        return this.semester;
    }
}
