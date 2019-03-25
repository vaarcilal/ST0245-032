import java.util.*;
import java.io.*;

/**
 * This class contains the methods necessary to read doto from a .txt document, transform it into Student objects, add tem to an ArrayList data structure and search said 
 * data tructure by semester and subject.
 *
 * @author Isabel Piedrahita
 * @version 24/03/2019
 */
public class MainSearchBySubject
{
    public String file;
    public String semester;
    
    public ArrayList<Student> records = new ArrayList<Student> ();
    
    public MainSearchBySubject(String subjectCode, String semester) {//Complexity O(1)
        this.file = "./" + subjectCode.toUpperCase() + ".txt";
        this.semester = semester;
    }
    
    public void readFile(String fileName, String skipLine) throws IOException {//Complexity O(n)
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
    
    public Student parseLine(String line, String separator) {//Complexity O(1)
        
        
        String[] info = line.split(separator);      
        Student s = new Student(info[1], info[3], info[12]);
        
        return s;   
    }
    
    public void searchBySemester(String semester) {//Complexity O(n)
        for(Student student: records) {
            if(student.getSemester().equals(semester)){
                student.print();
            }
        }
    }
    
    public static void main() throws IOException {//Complexity O(n) + O(n) + O(1) + O(n)
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el código de la materia en formato {ST} + {Codigo}: ");
        String subjectCode = s.nextLine();
        
        System.out.print("Ingrese el semestre en formato {Año} + {Semestre}: ");
        String semester = s.nextLine();
        
        MainSearchBySubject m = new MainSearchBySubject(subjectCode, semester);
        
        m.readFile(m.file, "");
        System.out.println("Los registros que coinciden con la busqueda son:");
        m.searchBySemester(m.semester);
    }
}