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

public Node removeLast(){
        Node pre = head;
        Node temp = head;

        if(length == 0){
            //if list begins empty
            return null;
        }
        else {
            while (temp.next != null){
                //while temp is not at end of list, pre will move to temp location
                //temp then moves on to next node and the check is made again
                pre = temp;
                temp = temp.next;
            }
            //once temp.next is null, end of list reached, pre is one step behind last Node
            //set tail to pre, moving it off last node thats being removed
            //tail.next = null removes last node, only temp is pointing to it now
            //decrement length of list
            tail = pre;
            tail.next = null;
            length--;
            //if list was at only one node left and remove called, must set head/tail to null
            if (length == 0){
                head = null;
                tail = null;
            }
            //return the removed Node
            return temp;
        }
}//END OF REMOVELAST


}
