import java.util.LinkedList;

/**
 * La clase BrokenKeyBoard resuelve el problema del teclado roto.
 * 
 * @author Alejandro Villada Toro
 * @author Cristian Alzate Urrea
 * @version 1
 */
public class BrokenKeyBoard {
    /**
     * El método brokenKeyBoard resuelve el problema del teclado roto utilizando una
     * lista doblemente enlazada.
     * 
     * @param text una cadena de caracteres a la que se le realizara el
     *             procedimiento.
     * @return la lista enlazada con el texto correcto.
     */
    public static LinkedList<String> brokenKeyBoard(String text) {
        LinkedList<String> list = new LinkedList<>();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == '[') {
                String wrongPosition = "";
                int j = i + 1;
                while (j < text.length() && text.charAt(j) != '[' && text.charAt(j) != ']') {
                    wrongPosition += text.charAt(j);
                    j++;
                }
                list.addFirst(wrongPosition);
                i = j;
            } else if (text.charAt(i) == ']') {
                int j = i + 1;
                while (j < text.length() && text.charAt(j) != '[' && text.charAt(j) != ']') {
                    list.addLast(Character.toString(text.charAt(j)));
                    j++;
                }
                i = j;
            } else {
                list.addLast(Character.toString(text.charAt(i)));
                i++;
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String text = "asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg";
        System.out.println(text.length());
        LinkedList<String> list = brokenKeyBoard(text);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}