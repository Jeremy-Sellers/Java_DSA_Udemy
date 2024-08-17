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

    public boolean contains(int value){
        Node temp = root;

        //while temp has not reached null value
        while (temp != null){
            //if searched value is less than temp, move temp down to next lower value
            if (value < temp.value){
                temp = temp.left;
            }
            //if searched value is greater than temp, move temp to next greater value
            else if (value > temp.value){
                temp = temp.right;
            }
            //if value == temp found, return true
            else {
                return true;
            }
        }
        //if temp reaches null on search for value, return false
        return false;
    }

    private boolean recursiveContains(Node currentNode, int value){
        if (currentNode == null){
            return false;
        }
        if (currentNode.value == value){
            return true;
        }
        if (value < currentNode.value){
            //if value is less than currentNode, move down-left in tree and rerun method
            return recursiveContains(currentNode.left, value);
        } else {
            return recursiveContains(currentNode.right, value);
        }
    }

    //user version of recursive contains
    //force start at root and search for input value
    public boolean recursiveContains(int value){
        return recursiveContains(root, value);
    }


}
