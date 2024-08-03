package chapters.sorting;

/**
 * @author Nane Petrosyan
 * 30.07.24
 */
public class PriorityQueue {
    private final int[] items;
    private int size;
    private final int capacity;

    public PriorityQueue(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.items = new int[capacity];
    }

    private int remove() {
        int item = items[0];
        swap(items, 0, size - 1);

        size--;
        sink(0);

        return item;
    }

    private void sink(int index) {
        while(2*index+1 < size) {
            int leftChild = items[getLeftChild(index)];
            int min = index;

            if (leftChild < items[min]) {
                min = getLeftChild(index);
            }

            if (getRightChild(index) < size) {
                if (items[getRightChild(index)] < items[min]) {
                    min = getRightChild(index);
                }
            }

            if(min == index) break;

            swap(items, index, min);
            index = min;
        }
    }

    private int getLeftChild(int index) {
        return 2*index + 1;
    }

    private int getRightChild(int index) {
        return 2*index + 2;
    }

    private void add(int item) {
        if (size > capacity) throw new RuntimeException();

        int index = size;
        items[index] = item;
        swim(index);

        size++;
    }

    private void swim(int index) {
        while(index > 0 && items[getParent(index)] > items[index]) {
            int parentIndex = getParent(index);
            swap(items, parentIndex, index);
            index = parentIndex;
        }
    }

    private int getParent(int index) {
        return (index - 1)/2;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(100);

        pq.add(70);
        pq.add(10);
        pq.add(50);
        pq.add(20);
        pq.add(60);
        pq.add(85);
        pq.add(30);
        pq.add(58);
        pq.add(90);
        pq.add(71);
        pq.add(99);
        pq.add(25);
        pq.add(82);

        pq.remove();
        pq.remove();
        pq.remove();
        pq.remove();
        pq.remove();
        pq.remove();
        pq.remove();
    }
}
