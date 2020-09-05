import java.util.Scanner;

public class Secuencia {
    public static IntMyArray secuencia(int n){
        IntMyArray arr = new IntMyArray();
        for(int i = 0; i<=n;i++){
            for(int j = 1; j<=i;j++){
                arr.add(j);
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        IntMyArray arr = secuencia(s.nextInt());
        s.close();
        System.out.println(arr);
    }
}
