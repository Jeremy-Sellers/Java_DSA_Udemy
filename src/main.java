public class main {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList(4);

        myLL.append(5);
        myLL.append(6);
        myLL.append(7);

        myLL.insert(2,55);

        myLL.printList();
        System.out.println('\n');

        System.out.println(myLL.get(2).value);


    }
}
