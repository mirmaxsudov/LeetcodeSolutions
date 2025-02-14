package univer_lesson.binaryHeapTree;

import java.util.Arrays;

public class BinaryHeapTree {
    private int size;
    private int[] array;
    private final int maxSize;

    public BinaryHeapTree(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        size = 0;
    }

    public void insert(int val) {
        if (size == maxSize)
            resize();

        array[size++] = val;
        trickleUp(size - 1);
    }

    public void delete(int val) {
        int index = -1;

        for (int i = 0; i < this.array.length; i++)
            if (array[i] == val) {
                index = i;
                break;
            }

        if (index == -1)
            return;

        array[index] = array[--size];
        array[size] = 0;

        trickleDown(index);
    }

    private void trickleDown(int index) {
        int smallest = index;
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        if (leftIndex < size && array[leftIndex] < array[smallest])
            smallest = leftIndex;

        if (rightIndex < size && array[rightIndex] < array[smallest])
            smallest = rightIndex;

        if (smallest != index) {
            swap(index, smallest);
            trickleDown(smallest);
        }
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    private void trickleUp(int index) {
        int parent = getParentIndex(index);
        if (index > 0 && array[index] < array[parent]) {
            swap(index, parent);
            trickleUp(parent);
        }
    }

    private int getRightChildIndex(int i) {
        return (i << 1) + 2;
    }

    private int getLeftChildIndex(int i) {
        return (i << 1) + 1;
    }

    private int getParentIndex(int chIndex) {
        return (chIndex - 1) >>> 1;
    }

    private void swap(int i, int parent) {
        array[i] += array[parent];
        array[parent] = array[i] - array[parent];
        array[i] -= array[parent];
    }

    public int size() {
        return this.size;
    }

    public int getMax() {
        return array[0];
    }

    public int getMin() {
        return array[size - 1];
    }

        @Override
        public String toString() {
            return "BinaryHeapTree{" +
                    "array=" + Arrays.toString(array) +
                    '}';
        }
}