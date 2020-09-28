import java.util.Arrays;
import java.util.LinkedList;

/**
 * La clase StaticBalance encuentra el equilibrio estatico de una viga.
 * 
 * @author Alejandro Villada Toro
 * @author Cristian Alzate Urrea
 * @version 1
 */
public class StaticBalance {
    /**
     * El método staticBalance encuentra el pivote donde una viga logra el
     * equilibrio estatico.
     * 
     * @param beam una lista enlazada de enteros que simula una viga.
     * @return el pivote donde se logra el equilibrio estatico de la viga.
     */
    public static int staticBalance(LinkedList<Integer> beam) {
        LinkedList<Integer> auxBeam = beam;
        int min = Integer.MAX_VALUE, pivot = 0;
        for (int i = 0; i < auxBeam.size(); i++) {
            int rightSide = 0, leftSide = 0;
            for (int j = 0; j < auxBeam.size(); j++) {
                if (j == i)
                    continue;
                else if (j < i)
                    leftSide += auxBeam.get(j);
                else
                    rightSide += auxBeam.get(j);

            }
            min = Math.min(min, Math.abs(leftSide - rightSide));
        }
        for (int i = 0; i < auxBeam.size(); i++) {
            int rightSide = 0, leftSide = 0;
            for (int j = 0; j < auxBeam.size(); j++) {
                if (j == i)
                    continue;
                else if (j < i)
                    leftSide += auxBeam.get(j);
                else
                    rightSide += auxBeam.get(j);

            }
            if (min == Math.abs(leftSide - rightSide)) {
                pivot = i;
                break;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
        LinkedList<Integer> beam = new LinkedList<>(Arrays.asList(10, 2, 5, 2, 11));
        System.out.println("El pivote es " + staticBalance(beam) + " en donde esta el peso "
                + beam.get(staticBalance(beam)) + "kg");
    }
}