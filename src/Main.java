public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer, Integer> queue = new ArrayQueue<>();

        queue.enqueue(new Node<>(1,7));
        queue.enqueue(new Node<>(2,10));
        queue.enqueue(new Node<>(3,3));
        queue.enqueue(new Node<>(4,2));

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(new Node<>(5,2));
        queue.enqueue(new Node<>(6,2));
        queue.enqueue(new Node<>(7,2));

        queue.enqueue(new Node<>(8,2)); //på index 0
        queue.enqueue(new Node<>(9,2));

        //här ska ny array skapas när first > 0
        //eftersom last = first - 1

        queue.enqueue(new Node<>(10,2));
        queue.enqueue(new Node<>(11,2));
        queue.enqueue(new Node<>(12,2));

    }

    private void bigPart() {
        LinkedQueue<Integer, Integer> queue = new LinkedQueue<>();

        queue.enqueue(new Node<>(1,7));
        queue.enqueue(new Node<>(2,10));
        queue.enqueue(new Node<>(3,3));
        queue.enqueue(new Node<>(4,2));

        BinaryTree<Integer, Integer> tree = new BinaryTree<>();

        int[] randomKeys = GenerateArray.sorted(10, 1000);
        int[] randomValues = GenerateArray.unSorted(10, 10);

        for (int i = randomKeys.length/2; i >=0 ; i--) {
            tree.add(randomKeys[i], randomValues[i]);
        }
        for (int i = randomKeys.length/2 + 1; i < randomKeys.length; i++) {
            tree.add(randomKeys[i], randomValues[i]);
        }

        for (Node<Integer, Integer> i: tree) {
            System.out.println("next value " + i.key);
        }
    }
}