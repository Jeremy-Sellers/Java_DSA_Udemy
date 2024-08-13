public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }


    //    instantiates a new LL whose value is value, assigns head and tail to first node
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void printList(){
        Node temp = head; //assign temp pointer to beginning of list

        //while temp not null, print out its value, then move forward in list
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);;
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);

        if (length == 0){ //if list empty, head & tail point to new Node
            head = newNode;
            tail = newNode;
        } else { //otherwise tail of list points to new Node
            tail.next = newNode; //current last/tail Node points to new Node
            tail = newNode; //tail pointer moves to new node at end of list
        }
        length++; //incriment length at end
    }


}
