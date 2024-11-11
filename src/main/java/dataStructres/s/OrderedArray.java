package dataStructres.s;

public class OrderedArray {
    private int[] array;
    private int size;
    private int nElems;

    public OrderedArray(int size) {
        this.array = new int[size];
        this.size = size;
        this.nElems = 0;
    }

    public int search(int val) {
        int left = 0, right = nElems - 1;

        while (true) {
            int middle = (left + right) / 2;
            int middleNum = array[middle];

            if (middleNum == val)
                return middle;

            if (left > right)
                return -1;

            if (middleNum > val)
                left = middle + 1;
            else
                right = middle - 1;
        }
    }

    public void insert(int val) {
        if (nElems == size) {
            int[] newArray = new int[size * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            size *= 2;
        }
    }

    public boolean delete(int val) {
        int index = search(val);

        if (index == -1)
            return false;

        for (int i = index; i < nElems; i++)
            array[index] = array[index + 1];

        return true;
    }
}