
public class Punto_1 {
    public static int notacion_polaca(String str) {

        String[] elements = str.split(" ");
        MyStack<String> stack = new MyStack<String>();

        for (String i: elements) {
            if (isNumeric(i)) {
                stack.push(i);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                String resultado = operate(num1, num2, i);
                stack.push(resultado);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static String operate(int num1, int num2, String operation) {
        String resultado = null;
        int resultadoInt = 0;
        if (operation.equals("+")) {
            resultadoInt = num1 + num2;
        } else if (operation.equals("-")) {
            resultadoInt = num1 - num2;
        } else if (operation.equals("*")) {
            resultadoInt = num1 * num2;
        } else if (operation.equals("/")) {
            resultadoInt = num1 / num2;
        } else if (operation.equals("^")) {
            resultadoInt = (int) Math.pow(num1, num2);
        } else {
        }
        resultado = "" + resultadoInt;
        return resultado;
    }
}