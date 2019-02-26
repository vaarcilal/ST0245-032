import java.util.Arrays;
public class MyArrayListChar {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private char elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MyArrayListChar() {
        size = 0;
        elements = new char[DEFAULT_CAPACITY];
    }     
    
    public void testSize(){
        if((size + 1) > elements.length){
            elements = Arrays.copyOf(elements, size * 2);
        }
    }
    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(char e) {
        testSize();
        elements[size] = e;
        size++;
    }    
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public char get(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= size){
           throw new ArrayIndexOutOfBoundsException("perdon usuario, pero i= " + i + " ,pero size = " + size);
        }else{
           return elements[i];
        }
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, char e) throws ArrayIndexOutOfBoundsException{
        testSize();
        if((index >= 0) && (index <= size)){
            for(int i = size - 1 ; i >= index ; i--){
                elements[i] = elements[i - 1];
            }
            size ++;
            elements[index] = e;
        }else{
            throw new ArrayIndexOutOfBoundsException("Por favor inserte el nuevo elemento en un indice entre 0 y " + size);
        }
    } 

    /**
    * @param index es la posicion en la cual se va agregar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index){
        testSize();
        for(int i = index ; i < size - 1 ; i++){
            elements[i] = elements[i + 1];
        }
        size--;
    }
}

