public class LinkedQueue extends Queue {
    private Node first;
    private Node firstNode;
    private Node lastNode;
    public LinkedQueue() {
        this.first = null;
    }
    @Override
    public void addAtEnd(Integer newItem) {
        if (this.first == null) {
            this.first = new Node(newItem, this.first); //nästa referens är null
            firstNode = this.first;
            lastNode = this.first;
        } else {
            lastNode = new Node(newItem, lastNode);
        }
    }
    @Override
    public void remove() {
        Node next = this.first;
        while (next.next != lastNode) {
            next = next.next;
        }
        lastNode = next;
    }
}
