public class ArrayQueue extends Queue {
    private final int[] staticQueue = new int[10];
    private int staticQueuePointer = 0; //k
    @Override
    public void addAtEnd(Integer newItem) {
        if (staticQueuePointer == staticQueue.length - 1) {
            throw new StackOverflowError("Full stack, cannot push");
        }
        staticQueue[staticQueuePointer] = newItem;
        staticQueuePointer++;
    }
    @Override
    public void remove() {
        if (staticQueue.length == 0) {
            return;
        }
        staticQueue[staticQueuePointer] = 0;
        staticQueuePointer--;
    }
}
