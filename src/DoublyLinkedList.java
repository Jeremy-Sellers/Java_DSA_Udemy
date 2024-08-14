public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;


    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
        }
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value){
        Node newNode = new Node(value);

        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; //adds Node to end of list
            newNode.prev = tail; //new node links back to 2nd to last node
            tail = newNode; //tail pointer moves to newly added node
        }
        length++;
    }

    public Node removeLast(){
        if (length == 0){
            return null;
        }

        Node temp = tail;
        if (length == 1){
            head = null;
            tail = null;
        } else{
            tail = tail.prev; //move tail back 1 node from end
            tail.next = null; //disconnect new last node from old
            temp.prev = null; //disconnect removed node from list
        }

        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if (length == 0){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; //connect new node to old 1st node
            head.prev = newNode; //connect old 1st node backwards to new front
            head = newNode; //move head pointer to new start
        }
        length++;
    }

    public Node removeFirst(){
        if (length == 0){
            return null;
        }

        Node temp = head;
        if (length == 1){
            head = null;
            tail = null;
        } else {
            head = head.next; //moves head forward to new first
            head.prev = null; //disconnects new first node from prev
            temp.next = null; //disconnects old first from list
        }
        length--;
        return temp;
    }

    public Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }

        Node temp = head;

        //if index in first half, start from front and move until index reached
        if (index < length/2){
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        } else { //if index in 2nd half, start from tail, move backwards until index reached
            temp = tail;
            for (int i = length - 1; i > index; i-- ){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
         if (temp != null){
             temp.value = value;
             return true;
         }
         return false;
    }

    public boolean insert(int index, int value){
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
        Node newNode = new Node(value);
        Node before = get(index-1); //node reference before index chosen to insert
        Node after = before.next; //node reference after index chosen to insert

        newNode.prev = before; //points new node prev connect to node before index
        newNode.next = after; //points new node next connect to node after index
        before.next = newNode; //connects before node to new node instead of old index node
        after.prev = newNode; //connects after node to new node instead of old index node
        length++;

        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= length){
            return null;
        }
        if (index == 0){
           return removeFirst();
        }
        if (index == length - 1){
            return removeLast();
        }
        Node temp = get(index);

        //assigns the prev attribute of the node AFTER temp to the node BEFORE temp
        temp.next.prev = temp.prev;
        //Assigns the next attribute of the node BEFORE temp to the node AFTER temp
        temp.prev.next = temp.next;

        //disconnects temp from prev and next nodes
        temp.next = null;
        temp.prev = null;
        length--;

        return temp;
    }
}
