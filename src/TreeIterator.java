import java.util.Iterator;
public class TreeIterator<K extends Comparable <K>,V> implements Iterator<Node<K,V>> {
    private final Queue<K,V> queue;
    public TreeIterator(Node<K,V> root) {
        this.queue = new LinkedQueue<>(); //kan ändras till ArrayQueue
        checkIfRootIsNull(root);
    }
    private void checkIfRootIsNull(Node<K,V> root) {
        if (root == null) {
            return;
        } else {
            pushInQueue(root);
        }
    }
    private void pushInQueue(Node<K,V> current) {
        queue.enqueue(current);
    }
    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
    @Override
    public Node<K,V> next() {
        Node<K,V> current = queue.dequeue();
        if(current.left != null) {
            pushInQueue(current.left);
        }
        if(current.right != null) {
            pushInQueue(current.right);
        }
        return current;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}