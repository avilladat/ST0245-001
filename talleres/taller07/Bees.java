import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Bees {
    public static MyLinkedList<Location> read(String dir) {
        MyLinkedList<Location> list = new MyLinkedList<Location>();
        try {
            File f = new File(dir);
            Scanner scan = new Scanner(f);
            if (scan.hasNextLine())
                scan.nextLine();
            while (scan.hasNextLine()) {
                String s = scan.nextLine();
                s = s.replace(',', ' ');
                s = s.replace('.', ',');
                Scanner ln = new Scanner(s);
                double x = ln.nextDouble();
                double y = ln.nextDouble();
                double z = ln.nextDouble();
                Location location = new Location(x, y, z);
                list.addInit(location);
                ln.close();
            }
            scan.close();
        } catch (FileNotFoundException err) {
        } catch (NoSuchElementException err2) {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) throws Exception{
        MyLinkedList<Location> list10 = read("ConjuntoDeDatosCon10abejas.txt"), list1000 = read("ConjuntoDeDatosCon1000abejas.txt");
        System.out.println(list10);
        System.out.println(list1000.contains(new Location(1, 11, 111)));
        Location element = new Location(1.0,1.0,1.0);
        list1000.add(element);
        System.out.println(list1000.contains(element));
        System.out.println(list1000.get(0));
        System.out.println(list1000.get(0).equals(element));
    }
}
