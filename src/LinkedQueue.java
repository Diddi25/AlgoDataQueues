public class LinkedQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private QueueCell<K,V> first;
    private QueueCell<K,V> last;
    public LinkedQueue() {
        this.first = null;
    }
    @Override
    public void addAtFirst(Node<K,V> newItem) {
        if (this.first == null) {
            this.first = new QueueCell<>(newItem, null); //nästa referens är null
            last = this.first;
        } else {
            last = new QueueCell<>(newItem, last);
        }
    }
    @Override
    public Node<K,V> remove() {
        QueueCell<K,V> firstInQueue = first;
        QueueCell<K,V> next = last;
        while (next.nextCell != first) {
            next = next.nextCell;
        }
        first = next;
        return firstInQueue.item;
    }
    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
