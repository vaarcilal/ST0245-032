import java.util.* ; 
import java.io.*;
class PosOrder {  
    public int[] makeArray() throws FileNotFoundException, IOException{
        String name = "input.txt";
        FileReader f = new FileReader(name);
        BufferedReader b = new BufferedReader(f);
        String line = "";
        int index = 0;
        ArrayList<Integer> data = new ArrayList<>();
        while((line = b.readLine()) != null){
            data.add(Integer.parseInt(line));
            index++;
        }
        int[] pre = new int[data.size()];
        for (int i=0; i < pre.length; i++)
        {
            pre[i] = data.get(i).intValue();
        }
        b.close();
        return pre;
    }
    
    static void findPostOrderAux(int pre[], int n, int minval, int maxval, Data preIndex)  
    {   
        if (preIndex.data == n) {
            return;  
        }
       
        if (pre[preIndex.data] < minval || pre[preIndex.data] > maxval) {  
            return;  
        }  
  
        int val = pre[preIndex.data];  
        preIndex.data++;  
 
        findPostOrderAux(pre, n, minval, val, preIndex);  

        findPostOrderAux(pre, n, val, maxval, preIndex);  
      
        System.out.println(val);  
    }  
       
    public void findPostOrder(int n, int[] pre) throws IOException {  
        Data preIndex = new Data(0);  
        
        findPostOrderAux(pre, n, Integer.MIN_VALUE, Integer.MAX_VALUE, preIndex);  
    }    
}