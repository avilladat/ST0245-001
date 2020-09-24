public class ReverseStack {
    public static MyStack<Integer> reverse(MyStack<Integer> stack) {
        MyStack<Integer> reversedStack = new MyStack<>();
        while (!stack.isEmpty()) {
            reversedStack.push(stack.pop());
        }
        return reversedStack;
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 1; i <= 4; i++)
            stack.push(i);
        System.out.println("Stack: " + stack);
        System.out.println("Reversed Stack: " + reverse(stack));
    }
}