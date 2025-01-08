package univer_lesson.binaryHeapTree;

public class Main {
    public static void main(String[] args) {
        BinaryHeapTree heap = new BinaryHeapTree(10);
        System.out.println(heap.size());

        heap.insert(40);
        heap.insert(15);
        System.out.println(heap.size());

        heap.insert(3);
        System.out.println(heap.size());

        heap.insert(10);
        System.out.println(heap.size());

        heap.insert(4);
        System.out.println(heap.size());

        heap.insert(1);
        System.out.println(heap.size());

        System.out.println(heap);

        for (int i = 50;  i < 60; i++)
            heap.insert(i);

        System.out.println(heap);
    }
}
