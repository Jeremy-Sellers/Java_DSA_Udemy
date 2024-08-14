

public class main {
    public static void main(String[] args) {

        Stack stack = new Stack(2);

        stack.printStack();
        System.out.println('\n');

        stack.push(3);
        stack.push(4);
        stack.printStack();

        stack.pop();
        System.out.println('\n');
        stack.printStack();
    }
}
