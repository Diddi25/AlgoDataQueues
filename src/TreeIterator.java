import java.util.Iterator;
public class TreeIterator<K extends Comparable <K>,V> implements Iterator<Node<K,V>> {
    private final Queue<K,V> queue;
    public TreeIterator(Node<K,V> root) {
        this.queue = new LinkedQueue<>(); //kan ändras till ArrayQueue
        pushAllLeftNodes(root);
    }
    private void pushAllLeftNodes(Node<K,V> current) {
        while(current != null) {
            queue.addAtFirst(current);
            current = current.left;
        }
    }
    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
    @Override
    public Node<K,V> next() {
        Node<K,V> current = queue.remove();
        if (current != null) {
            pushAllLeftNodes(current.right);
        }
        return current;
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}