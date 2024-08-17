import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    //returns copy of heap instead of actual heap
    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    //left child when utilizing 0 index
    public int leftChild(int index){
        return 2 * index + 1;
    }

    public int rightChild(int index){
        return 2 * index + 2;
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value); //adds value to end of list
        int current = heap.size() - 1; //point to end of list

        //run loop if current index greater than 0 (not beginning of list
        //AND value of current position greater than its parent
        while (current > 0 && heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current)); //swaps new value to parent position
            current = parent(current); //moves pointer to new position
        }
    }

    public void sinkDown(int index){
        int maxIndex = index; //set to top index

        while (true){
            int leftIndex = leftChild(index);//left of top index
            int rightIndex = rightChild(index);//right of top index

            //if left index exists to be swapped with
            //and value greater than top/max index, max pointer moves to left index
            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)){
                maxIndex = leftIndex;
            }

            //if right index exists to be swapped with
            //and value greater than top/max index, max pointer moves to right index
            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
                maxIndex = rightIndex;
            }

            //if maxIndex and index arent pointing to same node
            //swap values from index and maxIndex pointers
            //move index to maxIndex and rerun loop until they eventually match and complete the sink
            if (maxIndex != index){
                swap(index, maxIndex);
                index = maxIndex;
            } else {
                return;
            }

        }
    }

    //ALWAYS ONLY REMOVES TOP NODE
    public Integer remove(){
        if (heap.size() == 0){return null;}
        if (heap.size() == 1){return heap.remove(0);}

        int maxValue = heap.get(0); //get value from top of list

        //takes last value in tree and sets it to top of tree
        heap.set(0, heap.remove(heap.size() - 1));

        sinkDown(0);

        //once
        return maxValue;
    }

}
