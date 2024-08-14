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

    public void prepend(int value){
        Node newNode = new Node(value);

        if (length == 0){
            //if list empty, set head/tail to new Node
            head = newNode;
            tail = newNode;
        } else {
           newNode.next = head; //new node placed in front of head Node
           head = newNode; //head pointer changed to new front of list
        }
        length++; //incriment at end
    }

    public Node removeFirst(){
        //if list starts empty
        if (length == 0){
            return null;
        }
        Node temp = head; //set temp to head to return removed Node
        head = head.next; //move head to new front of list
        temp.next = null; //removes old front from list
        length--; //decrement length
        if (length == 0){
            //if list ends up empty, must set tail to null
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }
        //create Node to traverse
        Node temp = head;
        //traverse until i reaches index
        for (int i = 0; i < index; i++){
            //every loop, temp moves forward in list until index reached
            temp = temp.next;
        }
        //return after index reached
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index); //get index using get method

        //if index exists, change value at index to value
        if (temp != null){
            temp.value = value;
            return true;
        }

        //if index doesnt exist, return false
        return false;
    }

    public boolean insert(int index, int value){
        Node newNode = new Node(value);
        Node pre = head;
        Node temp = head;
        Node udemyTemp = get(index - 1);

        if (index < 0 || index > length){
            return false;
        }
        if (index == 0){
            prepend(value);
            return true;
        }
        if (index == length){
            append(value);
            return true;
        }

        //MY SOLUTION
//        for (int i = 0; i < index; i++){
//            pre = temp;
//            temp = temp.next;
//        }
//        pre.next = newNode;
//        newNode.next = temp;
//        length++;
//        return true;

        //Udemy Solution
        newNode.next = udemyTemp.next;
        udemyTemp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        Node pre = get(index-1);
        Node temp = pre.next;

        if (index < 0 || index >= length){
            return null;
        }
        if (index == 0){
            return removeFirst();
        }
        if (index == length - 1){
            return removeLast();
        }

        pre.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse() {
        Node temp = head; //set to front of list
        head = tail; //set head to back of list
        tail = temp; //set tail to front of list
        Node after = temp.next;
        Node before = null;

        for (int i = 0; i < length; i++){
            after = temp.next;//after moves forward in list
            temp.next = before; //temp in middle, turns around
            //gap created between nodes
            before = temp; //before and tempt point at same node
            //before holds disconnected node
            temp = after;//temp and after point at same node
            //temp jumps gap to afters node, prepares to turn around
        }
    }


}
