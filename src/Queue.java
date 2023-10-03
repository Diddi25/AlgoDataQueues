public abstract class Queue<K extends Comparable <K>,V> {
    public abstract void enqueue(Node<K,V> newItem);
    public abstract Node<K,V> dequeue();
    public abstract boolean isEmpty();
}
