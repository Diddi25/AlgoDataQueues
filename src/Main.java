public class Main {
    public static void main(String[] args) {
        LinkedQueue<Integer, Integer> queue = new LinkedQueue<>();

        queue.addAtFirst(new Node<>(1,7));
        queue.addAtFirst(new Node<>(2,10));
        queue.addAtFirst(new Node<>(3,3));
        queue.addAtFirst(new Node<>(4,2));

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