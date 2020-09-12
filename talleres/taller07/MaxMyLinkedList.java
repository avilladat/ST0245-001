public class MaxMyLinkedList {
    public static int maxMyLinkedList(MyLinkedList<Integer> list) throws Exception{
        int c = list.get(0);
        for(int i = 0; i < list.size(); i++){
            c = Math.max(c, list.get(i));
        }
        return c;
    }

    public static void main(String[] args) throws Exception{
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        for(int i=1;i<=10;i++) list.add(i);   
        System.out.println("Los elementos de la lista son: ");
        System.out.println(list);
        System.out.println("El mayor elemento es: ");
        System.out.println(maxMyLinkedList(list));
    }
}