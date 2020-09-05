import java.util.Arrays;

public class IntMyArray {
    private int size;
    private final int TAMAÑO_INICIAL = 4;
    private int[] arr;

    public IntMyArray(){
        size = 0;
        arr = new int[TAMAÑO_INICIAL];
    }

    public int getSize(){
        return size;
    }

    public void add(int a){
        if (size == arr.length){
            arr = Arrays.copyOf(arr, arr.length*2);
        }
        arr[size] = a;
        size++;
    }

    public void add(int a, int index) throws Exception{
        if (index < 0 || index > size)                         
            throw new Exception("index: " + index);
        
        else if (size == arr.length)
            arr = Arrays.copyOf(arr, arr.length * 2);

        int temp = arr[index];
        for (int i = index ; i < size - 1; i++){
            int temp2 = arr[i+1];
            arr[i+1] = temp;
            temp = temp2;
        }
        arr[size] = temp;
        arr[index] = a;
        size++;
    }

    public int get(int index) throws Exception{
        if (index < 0 || index >= size)
            throw new Exception("index: " + index); 
        return arr[index];
    }

    public void remove(){
        arr[size - 1] = 0;
        size--;
    }

    public void remove(int index) throws Exception{
        if (index < 0 || index >= size)
            throw new Exception("index: " + index);

        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[size-1] = 0;
        size--;
    }

    public void replace(int a, int index) throws Exception{
        if (index < 0 || index >= size)
            throw new Exception("index: " + index);
        arr[index] = a;
    }

    public String toString(){
        String temp = "[";
        for (int i = 0; i < size; i++){
            if (i != size - 1) temp += arr[i] + ",";
            else temp += arr[i];
        }
        temp += "]";
        return temp;
    }

}