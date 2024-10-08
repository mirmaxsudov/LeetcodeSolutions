package dataStructres;

public class Task1 {
    public static void main(String[] args) {
        MyList myList = new MyList(5);

        myList.insert(1);
        myList.insert(2);
        myList.insert(3);
        myList.insert(4);
        myList.insert(5);
        myList.insert(6);

        System.out.println(myList.get(3));
        System.out.println(myList.get(561));
        System.out.println(myList.delete(4));
    }
}

class MyList {
    private int[] array;
    private int size;
    private int nElems;

    public MyList(int size) {
        this.array = new int[size];
        this.size = size;
        this.nElems = 0;
    }

    public void insert(int value) {
        if (this.nElems == this.size) {
            int[] newArray = new int[this.size * 2];

            System.arraycopy(this.array, 0, newArray, 0, this.size);

            this.array = newArray;
            this.size *= 2;
        }

        this.array[this.nElems] = value;
        nElems++;
    }

    public int get(int value) {
        for (int i = 0; i < nElems; i++)
            if (array[i] == value)
                return i;

        return -1;
    }

    public int delete(int value) {
        int index = get(value);

        if (index == -1)
            return -1;

        for (int i = index; i < nElems - 1; i++)
            array[i] = array[i + 1];

        nElems--;
        return value;
    }
}