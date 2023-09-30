public class LinkedQueue<K extends Comparable<K>,V> extends Queue<K,V> {
    private Cell<K,V> first;
    private Cell<K,V> last;
    public LinkedQueue() {
        this.first = null;
    }
    @Override
    public void addAtFirst(Node<K,V> newItem) {
        if (this.first == null) {
            this.first = new Cell<K,V>(newItem, null); //nästa referens är null
            last = this.first;
        } else {
            last = new Cell<K,V>(newItem, last);
        }
    }
    @Override
    public Node<K,V> remove() {
        Cell<K,V> firstInQueue = first;
        first = first.next;
        return firstInQueue.item;
    }
    @Override
    public boolean isEmpty() {
        return first == null;
    }
}
