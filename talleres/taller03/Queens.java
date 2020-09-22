import java.util.LinkedList;

public class Queens {
    public static boolean check(int n, int[] board) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (board[i] == board[j] || (Math.abs(i - j) == Math.abs(board[i] - board[j])))
                    return false;
                else
                    continue;
            }
        }
        return true;
    }

    public static void queens(int n, int[] board, LinkedList<int[]> solutions) {
        if (n == board.length) {
            if (check(n, board)) {
                solutions.addFirst(board);
                //System.out.println(printArray(board));
            }
            return;
        } else {
            for (int i = 0; i < board.length; i++) {
                board[n] = i;
                queens(n + 1, board, solutions);
            }
        }
    }

    public static void SolveQueens(int n) {
        int[] board = new int[n];
        LinkedList<int[]> solutions = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            board[i] = -1;
        }
        queens(0, board, solutions);
        System.out.println("Solutions: " + solutions.size());
    }

    public static String printArray(int[] array) {
        String text = "[";
        for (int i = 0; i < array.length; i++) {
            text += array[i] + ",";
        }
        return text.substring(0, text.length() - 1) + "]";
    }

    public static void main(String[] args) {
        double t = System.currentTimeMillis();
        SolveQueens(11);
        System.out.println(System.currentTimeMillis()-t);
    }
}