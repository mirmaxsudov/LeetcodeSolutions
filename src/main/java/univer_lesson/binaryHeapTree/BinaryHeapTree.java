package univer_lesson.binaryHeapTree;

import java.util.Arrays;

public class BinaryHeapTree {
    private int[] array;
    private int size;
    private int maxSize;

    public BinaryHeapTree(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        size = 0;
    }

    public void delete(int val) {

    }

    public void insert(int val) {
        if (size == maxSize) {
            resize();
        }

        array[size++] = val;
        heapIfyUp(size - 1);
    }

    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    private void heapIfyUp(int i) {
        int parent = getParentIndex(i);
        if (i > 0 && array[i] < array[parent]) {
            swap(i, parent);
            heapIfyUp(parent);
        }
    }

    private int getParentIndex(int chIndex) {
        return (chIndex - 1) >>> 1;
    }

    private void swap(int i, int parent) {
        array[i] += array[parent];
        array[parent] = array[i] - array[parent];
        array[i] -= array[parent];
//        int temp = array[i];
//        array[i] = array[parent];
//        array[parent] = temp;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "BinaryHeapTree{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}