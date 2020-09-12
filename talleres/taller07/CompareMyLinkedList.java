public class CompareMyLinkedList {
    public static boolean compareMyLinkedListaux(MyLinkedList<Integer> a, MyLinkedList<Integer> b, int n) throws Exception {
        if (a.size() != b.size())
            return false;
        if (n == 0 && a.get(n) != b.get(n))
            return false;
        else if (n == 0)
            return true;
        else
            return compareMyLinkedListaux(a, b, n - 1);
    }

    public static boolean compareMyLinkedList(MyLinkedList<Integer> a, MyLinkedList<Integer> b) throws Exception {
        int n = a.size() - 1;
        return compareMyLinkedListaux(a, b, n);
    }

    public static void main(String[] args) throws Exception {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>(), b = new MyLinkedList<Integer>();
        for (int i = 1; i <= 10; i++) {
            a.add(i);
            b.add(i);
        }
        b.delIndex(2);
        System.out.println(compareMyLinkedList(a, b));
        System.out.println("a="+a+"   b="+b);
    }
}