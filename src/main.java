

public class main {
    public static void main(String[] args) {

        Queue newQueue = new Queue(5);

        newQueue.enqueue(6);
        newQueue.enqueue(7);

        newQueue.printQueue();

        System.out.println('\n');

        newQueue.dequeue();
        newQueue.printQueue();
        System.out.println('\n');

        newQueue.enqueue(8);
        newQueue.printQueue();

    }
}
