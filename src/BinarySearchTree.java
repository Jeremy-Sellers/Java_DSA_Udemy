public class BinarySearchTree {
    Node root;


    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);

        //if tree empty, place new node at root
        if (root == null){
            root = newNode;
            return true;
        }

        Node temp = root;
        //loop will continuously run until return ran
        while (true){
            //each iteration checks if new node value already exists in tree
            if (newNode.value == temp.value){
                return false;
            }
            //runs check to see if new node less than temp current node
            if (newNode.value < temp.value){
                //if left(lesser) is open, place newNode
                if (temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                //if left not open but newNode is less, than temp, move temp down tree, restart while loop
                temp = temp.left;
            } else {
                //if newNode bigger than temp
                //if right(greater) is open, place newNode
                if (temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                //if right spot not open, move temp down tree and restart loop for checking
                temp = temp.right;
            }

        }

    }


}
