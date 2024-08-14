public class Stack {
    private Node top;
    private int height;

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }


    public void printStack(){
        Node temp = top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getTop(){
        System.out.println("Top: " + top.value);
    }

    public void getHeight(){
        System.out.println("Height: " + height);
    }

    public void push(int value){
        Node newNode = new Node(value);

        if (height == 0){
            top = newNode;
        } else {
            newNode.next = top; //points down to old top of stack
            top = newNode; //moves top to new top
        }
        height++;
    }

    public Node pop(){
        if (height == 0){
            return null;
        }
            Node temp = top;

            top = top.next; //move down stack
            temp.next = null; //disconnect old top from stack

        height--;
        return temp;
    }
}
