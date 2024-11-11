package dataStructres.stack;

public class CustomStack {
    private int[] array;
    private int size;
    private int nElem;

    public CustomStack(int size) {
        array = new int[size];
        this.size = size;
        this.nElem = 0;
    }

    public void push(int value) {
        if (isFull()) {
            int[] newArray = new int[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            this.size = newArray.length;
            array = newArray;
        }

        array[nElem] = value;
        nElem++;
    }

    public int pop() {
        return array[--nElem];
    }

    public int peek() {
        return array[nElem - 1];
    }

    public boolean isEmpty() {
        return nElem == 0;
    }

    public boolean isFull() {
        return nElem == size - 1;
    }

    public void show() {
        for (int i = 0; i < nElem; i++)
            System.out.print(array[i] + " ");

        System.out.println();
    }
}