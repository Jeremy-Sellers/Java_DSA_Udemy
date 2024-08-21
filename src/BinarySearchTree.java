import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    private Node recursiveInsert(Node currentNode, int value){

        if (currentNode == null){
            return new Node(value);
        }

        //everytime loop runs, currentNode becomes either the left or right child based on direction needed to move from the previous call

        //if value less than current, rerun insert against lower left child
        if (value < currentNode.value){
            currentNode.left = recursiveInsert(currentNode.left, value);
        }
        //if value is greater than current, rerun insert against lower right child
        else if (value > currentNode.value){
            currentNode.right = recursiveInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void recursiveInsert(int value){
        if (root == null) { root = new Node(value);}
        recursiveInsert(root, value);
    }

    //helped method for recursiveDeleteNode
    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }



    private Node recursiveDeleteNode(Node currentNode, int value){
       //if value not found through traversal, returns null
        if (currentNode == null){
            return null;
        }

        //traverses left/right looking for value in tree
        if (value < currentNode.value){
            currentNode.left = recursiveDeleteNode(currentNode.left, value);
        } else if (value > currentNode.value){
            currentNode.right = recursiveDeleteNode(currentNode.right, value);
        }
        //if value found, runs below code
        else {
            //if node to be deleted has no children/ only right child/ or only left child
            if (currentNode.left == null && currentNode.right == null){
                return null;
            } else if(currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null){
                currentNode = currentNode.left;
            }
            //if node has left & right children
            else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = recursiveDeleteNode(currentNode.right, subTreeMin);
            }
        }

        return currentNode;
    }

    public void recursiveDeleteNode(int value){
        recursiveDeleteNode(root, value);
    }



    public ArrayList<Integer> BreadthFirstSearch(){
        Node currentNode = root;
        //built in Queue
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();

        //adds root to front of queue
        queue.add(currentNode);


        while (queue.size() > 0){
            //dequeue front of queue and add value to results
            currentNode = queue.remove();
            results.add(currentNode.value);

            //check for left/right children
            if (currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }

            //restarts at beginning of queue
        }

        return results;
    }
}
