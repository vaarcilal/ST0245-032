import java.util.*;
import java.io.*;

public class MainSearchStudentSemester
{
    //public String file;
    public String studentCode;
    public String semester;
    
    public ArrayList<Student> records = new ArrayList<Student> ();
    
    public MainSearchStudentSemester(String semester, String studentCode) {//Complexity O(1)
        this.studentCode = studentCode;
        this.semester = semester;
    }
    
    public void readFile(String skipLine) throws IOException {//Complexity O(n)
        FileReader reader = new FileReader("ST0242.txt");
        BufferedReader b = new BufferedReader(reader);
        
        String line = "";
        while((line = b.readLine()) != null){ 
            if(! line.equals(skipLine)){
                Student s = parseLine(line, ",");
                records.add(s);
            }
        }
        
        
        reader = new FileReader("ST0245.txt");
        b = new BufferedReader(reader);
        
        String line1 = "";
        while((line1 = b.readLine()) != null){ 
            if(! line1.equals(skipLine)){
                Student s = parseLine(line1, ",");
                records.add(s);
            }
        }
        
        
        reader = new FileReader("ST0247.txt");
        b = new BufferedReader(reader);
        
        String line2 = "";
        while((line2 = b.readLine()) != null){ 
            if(! line2.equals(skipLine)){
                Student s = parseLine(line2, ",");
                records.add(s);
            }
        }
        
        b.close();
    }
    
    public Student parseLine(String line, String separator) {//Complexity O(1)
        
        
        String[] info = line.split(separator);      
        Student s = new Student(info[1], info[3], info[12], info[2]);
        
        return s;   
    }
    
    public void searchBySemester(String semester, String student) {//Complexity O(n)
        for(Student s: records) {
            if(s.getSemester().equals(semester) && s.getCode().equals(student)){
                s.printWithSubject();
            }
        }
    }
    
    public static void main() throws IOException {//Complexity O(n) + O(n) + O(1) + O(n)
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el código del estudiante que desea buscar: ");
        String studentCode = s.nextLine();
        
        System.out.print("Ingrese el semestre en formato {Año} + {Semestre}: ");
        String semester = s.nextLine();
        
        MainSearchStudentSemester m = new MainSearchStudentSemester(semester, studentCode);
        
        m.readFile("");
        System.out.println("Los registros que coinciden con la busqueda son:");
        m.searchBySemester(m.semester, m.studentCode);
    }
}
