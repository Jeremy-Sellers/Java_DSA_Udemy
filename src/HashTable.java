import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] datamap;

    public HashTable(){
        datamap = new Node[size];
    }

    class Node{
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public void printTable(){
        for (int i = 0; i < datamap.length; i++){
            System.out.println(i + ":");
            Node temp = datamap[i];
            while (temp != null){
                System.out.println("  {" + temp.key + " =" + temp.value + " }");
                temp = temp.next;
            }
        }
    }

    private int hash(String key){
        int hash = 0;

        //split key into array of char
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % datamap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);

        Node newNode = new Node(key, value);

        //if index empty, place newNode
        if (datamap[index] == null){
            datamap[index] = newNode;
        } else {
            //points to first node in list
            Node temp = datamap[index];

            //traverse through node list until end
            while (temp.next != null){
                temp = temp.next;
            }
            //place new node at end of list
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hash(key); //finds index of key

        Node temp = datamap[index];// sets temp to found index
        //loops through list until key found
        while (temp != null){
            if (temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0; //if item not found
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        //loops through each storage space in datamap
        for (int i = 0; i < datamap.length; i++){
            //temp points to section of datamap
            Node temp = datamap[i];
            //loop through storage and add each element into allkeys arraylist
            while (temp != null){
                allKeys.add(temp.key);
                //once all keys from storage space added, exit while loop and iterate i to move to next storage space in datamap
                temp = temp.next;
            }
        }
        return allKeys;
    }
}
