
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
