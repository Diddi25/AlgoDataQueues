public class QueueCell  <K extends Comparable <K>,V> {
    Node<K,V> item;
    QueueCell<K,V> nextCell;
    public QueueCell(Node<K,V> item, QueueCell<K,V> nextCell) {
        this.item = item;
        this.nextCell = nextCell;
    }

}
