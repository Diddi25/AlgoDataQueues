public abstract class Queue<K extends Comparable <K>,V> {
    public abstract void addAtFirst(Node<K,V> newItem);
    public abstract Node<K,V> remove();
    public abstract boolean isEmpty();
}
