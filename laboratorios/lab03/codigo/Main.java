import java.util.*;
import java.io.*;

public class Main
{
    public String file = "ST0242.txt";
    public String semester = "20142";
    
    public LinkedList<Student> records = new LinkedList<Student> ();
    
    public Main(String subjectCode, String semester) {
        this.file = "./" + subjectCode.toUpperCase() + ".txt";
        this.semester = semester;
    }
    
    public void readFile(String fileName, String skipLine) throws IOException {
        FileReader reader = new FileReader(fileName);
        BufferedReader b = new BufferedReader(reader);
        
        String line = "";
        while((line = b.readLine()) != null){
            if(! line.equals(skipLine)){
                Student s = parseLine(line, ",");
                records.add(s);
            }
        }
        
        b.close();
    }
    
    public Student parseLine(String line, String separator) {
        
        
        String[] info = line.split(separator);      
        Student s = new Student(info[1], info[3], info[12]);
        
        return s;   
    }
    
    public void searchBySemester(String semester) {
        for(Student student: records) {
            if(student.getSemester().equals(semester)){
                student.print();
            }
        }
    }
    
    public static void main() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el código de la materia en formato {ST} + {Codigo}: ");
        String subjectCode = s.nextLine();
        
        System.out.print("Ingrese el semestre en formato {Año} + {Semestre}: ");
        String semester = s.nextLine();
        
        Main m = new Main(subjectCode, semester);
        
        m.readFile(m.file, "");
        System.out.println("Los registros que coinciden con la busqueda son:");
        m.searchBySemester(m.semester);
    }
}