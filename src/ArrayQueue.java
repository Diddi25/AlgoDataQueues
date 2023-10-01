public class ArrayQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private Node<K,V>[] theQueue = new Node[7];
    private int first = 0;
    private int last = 0;
    private int queueLength = theQueue.length;
    @Override
    public void addAtFirst(Node<K,V> newItem) {
        if (last == queueLength && first > 0) {
            last = 0;
        }
        if (last == first - 1 || (last == queueLength && first == 0)) {
            allocateNewBiggerArray(first, last);
        }
        theQueue[last] = newItem;
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
        int iterateFirstItems = giveLengthDependingOnFirst(first);
        for (int i = 0; i < iterateFirstItems; i++) {
            biggerQueue[i] = this.theQueue[first];
            first++;
        }
        if (iterateFirstItems != queueLength) {
            for (int i = iterateFirstItems; i < queueLength - first; i++) {
                biggerQueue[i] = this.theQueue[last];
                last++;
            }
        }
        this.theQueue = biggerQueue;
        this.queueLength = queueLength*2;
    }
    private int giveLengthDependingOnFirst(int first) {
        if (first == 0) {
            return queueLength;
        } else {
            return queueLength - last;
        }
    }
}
