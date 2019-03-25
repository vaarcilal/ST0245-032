import java.util.*;
import java.io.*;

public class Main
{
    public static void main() throws IOException{
        System.out.println("Ingrese 1 para buscar por materia y 2 para buscar por estudiante.");
        Scanner scan = new Scanner(System.in);
        int searchBy = scan.nextInt();
        
        if(searchBy == 1){
            MainSearchBySubject ss = new MainSearchBySubject("","");
            ss.main();
        }else if(searchBy == 2){
            MainSearchStudentSemester st = new MainSearchStudentSemester("","");
            st.main();
        }else{
            System.out.println("Por favor ingrese un valor aceptado.");
            main();
        }
    }
}
