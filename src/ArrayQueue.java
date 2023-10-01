public class ArrayQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private final Node<K,V>[] theQueue = new Node[10];
    private int first = 0;
    private int last = 0;
    private int queueLength = theQueue.length;
    @Override
    public void addAtFirst(Node<K,V> newItem) {
        if (last == queueLength - 1) {
            last = 0;
        }
        if (first == 0) {
            theQueue[first] = newItem;
            last++;
        } else {
            theQueue[last] = newItem;
            last++;
        }
    }
    @Override
    public Node<K,V> remove() {
        if(isEmpty()) {
            return null;
        }
        Node<K,V> saveBeforeReturning = theQueue[first];
        theQueue[first] = null;
        first++;
        if(first == queueLength - 1) {
            first = 0;
        }
        return saveBeforeReturning;
    }
    @Override
    public boolean isEmpty() {
        return first == last;
    }
}
