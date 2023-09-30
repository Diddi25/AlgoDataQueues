public class Cell<K extends Comparable <K>,V> {
    Node<K,V> item;
    Cell<K,V> next;
    public Cell(Node<K,V> item, Cell<K,V> list) {
        this.item = item;
        this.next = list;
    }

}
