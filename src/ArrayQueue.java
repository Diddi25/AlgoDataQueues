public class ArrayQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private final Node<K,V>[] staticQueue = new Node[10];
    private int staticQueuePointer = 0; //k
    private Node<K,V> first;
    private Node<K,V> last;
    @Override
    public void addAtFirst(Node<K,V> newItem) {
        if (staticQueuePointer == staticQueue.length - 1) {
            throw new StackOverflowError("Full stack, cannot push");
        }
        staticQueue[staticQueuePointer] = newItem;
        staticQueuePointer++;
    }
    @Override
    public Node<K,V> remove() {
        if (staticQueue.length == 0) {
            return null;
        }
        staticQueue[staticQueuePointer] = 0;
        staticQueuePointer--;
        return 0;
    }
    @Override
    public boolean isEmpty() {
        return first == last;
    }
}
