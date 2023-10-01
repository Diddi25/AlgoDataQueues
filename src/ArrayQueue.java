public class ArrayQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private Node<K,V>[] theQueue = new Node[10];
    private int first = 0;
    private int last = 0;
    private int queueLength = theQueue.length;
    @Override
    public void addAtFirst(Node<K,V> newItem) {
        if (last == queueLength - 1) {
            last = 0;
        }
        if (last == first - 1) {
            allocateNewBiggerArray(first, last);
        }
        if (first == 0) {
            theQueue[first] = newItem;
        } else {
            theQueue[last] = newItem;
        }
        last++;
    }
    @Override
    public Node<K,V> remove() {
        if (isEmpty()) {
            return null;
        }
        Node<K,V> saveBeforeReturning = theQueue[first];
        theQueue[first] = null;
        first++;
        if (first == queueLength - 1) {
            first = 0;
        }
        return saveBeforeReturning;
    }
    @Override
    public boolean isEmpty() {
        return first == last;
    }
    private void allocateNewBiggerArray(int first, int last) {
        Node<K,V>[] biggerQueue = new Node[queueLength*2];
        for (int i = 0; i < queueLength - last; i++) {
            biggerQueue[i] = this.theQueue[first];
            first++;
        }
        for (int i = queueLength - last; i < queueLength - first; i++) {
            biggerQueue[i] = this.theQueue[last];
            last++;
        }
        this.theQueue = biggerQueue;
        this.queueLength = queueLength*2;
    }
}
