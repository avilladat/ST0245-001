import java.util.Scanner;

public class LeerInvertido {
    public static IntMyArray invertir(IntMyArray arr) throws Exception{
        int j = arr.getSize()-1;
        for(int i=0;i<(int)(arr.getSize()/2);i++){
            int temp = arr.get(i);
            arr.replace(arr.get(j), i);
            arr.replace(temp, j);
            j--;
        }
        return arr;
    }
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(System.in);
        IntMyArray arr = new IntMyArray();
        System.out.println("Ingrese un numero");
        int n = s.nextInt();
        while (n!=-1){
            arr.add(n);
            System.out.println("Ingrese un numero"); 
            n = s.nextInt();   
        }
        s.close();
        System.out.println(invertir(arr));
    }
}
