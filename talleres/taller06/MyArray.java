import java.util.Arrays;

public class MyArray {
    private int size;
    private final int TAMAÑO_INICIAL = 4;
    private Coordenada[] arr;

    public MyArray(){
        size = 0;
        arr = new Coordenada[TAMAÑO_INICIAL];
    }

    public int getSize(){
        return size;
    }

    public void add(Coordenada a){
        if (size == arr.length){                                //T2(n) = C_1           C_1 = 2
            arr = Arrays.copyOf(arr, arr.length*2);             //T3(n) = C_2*n         C_2 = 3
        }
        arr[size] = a;                                          //T4(n) = C_3           C_3 = 2
        size++;                                                 //T5(n) = C_4           C_4 = 1
    }
                                                                //T(n) = C_1 + C_2*n + C_3 + C_4
                                                                //Aplicando la notacion O: T(n) es O(C_1 + C_2*n + C_3 + C_4)
                                                                //Aplicando las reglas de suma y producto T(n) es O(n)

    public void add(Coordenada a, int index) throws Exception{
        if (index < 0 || index > size)
            throw new Exception("index: " + index);
        
        else if (size == arr.length)                            //T2(n) = C_1           C_1 = 2
            arr = Arrays.copyOf(arr, arr.length * 2);           //T3(n) = C_2*n         C_2 = 3

        Coordenada temp = arr[index];                           //T4(n) = C_3           C_3 = 2
        for (int i = index ; i < size - 1; i++){                //T5(n) = C_4*n         C_4 = 3
            Coordenada temp2 = arr[i+1];                        //T6(n) = C_5*n         C_5 = 3
            arr[i+1] = temp;                                    //T7(n) = C_6*n         C_6 = 2
            temp = temp2;                                       //T8(n) = C_7*n         C_7 = 1
        }
        arr[size] = temp;                                       //T9(n) = C_8           C_8 = 2
        arr[index] = a;                                         //T10(n) = C_9          C_9 = 2
        size++;                                                 //T11(n) = C_10         C_10 = 1
    }
                                                                //T(n) = C_1 + C_2*n + C_3 + C_4*n + C_5*n + C_6*n + C_7*n + C_8 + C_9 + C_10
                                                                //Aplicando la notacion O: T(n) es O(C_1 + C_2*n + C_3 + C_4*n + C_5*n + C_6*n + C_7*n + C_8 + C_9 + C_10)
                                                                //Aplicando las reglas de suma y producto T(n) es O(n)

    public Coordenada get(int index) throws Exception{
        if (index < 0 || index >= size)
            throw new Exception("index: " + index);
        
        return arr[index];
    }

    public void remove(){
        arr[size - 1] = null;
        size--;
    }

    public void remove(int index) throws Exception{
        if (index < 0 || index >= size)
            throw new Exception("index: " + index);

        for (int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[size-1] = null;
        size--;
    }

    public void replace(Coordenada a, int index) throws Exception{
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
