
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Main {
    public static void main (String [] args){
        MyArray arr = leerTXT("ConjuntoDeDatosCon10abejas.txt");
        System.out.println(arr);
        System.out.println((""));

        try{
            arr.remove(0);
        }catch(Exception e){}
        System.out.println(arr);
        System.out.println((""));

        try{
            arr.add(new Coordenada(1,1,1), 0);
        }catch(Exception e){}
        System.out.println(arr);
        System.out.println((""));
    }

    public static MyArray leerTXT(String direccion){
        MyArray arr = new MyArray();
        try {
            File f = new File(direccion);
            Scanner sc = new Scanner(f);
            if (sc.hasNextLine()) sc.nextLine();
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                s = s.replace(',', ' ');
                s = s.replace('.', ',');
                Scanner ln = new Scanner(s);
                float x = ln.nextFloat();
                float y = ln.nextFloat();
                float z = ln.nextFloat();
                Coordenada c = new Coordenada(x, y, z);
                arr.add(c);
                ln.close();
            }
            sc.close();
        } catch(FileNotFoundException err){
        } catch (NoSuchElementException err2) {
        }catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }
}
