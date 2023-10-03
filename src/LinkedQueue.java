public class LinkedQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private QueueCell<K,V> first;
    private QueueCell<K,V> last;
    public LinkedQueue() {
        this.first = null;
    }
    @Override
    public void enqueue(Node<K,V> newItem) {
        if (this.first == null) {
            this.first = new QueueCell<>(newItem, null); //nästa referens är null
            last = this.first;
        } else {
            last.nextCell = new QueueCell<>(newItem, null);;
            last = last.nextCell;
        }
    }
    @Override
    public Node<K,V> dequeue() {
        if(this.first == null) {
            return null;
        }
        QueueCell<K,V> firstInQueue = first;
        first = first.nextCell;
        return firstInQueue.item;
    }
    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
