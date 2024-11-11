package dataStructres.stack;

public class StackCustom {
    private Character[] a;
    private int ele;
    private int size;

    public StackCustom(int size) {
        a = new Character[size];
        this.size = size;
        ele = -1;
    }

    public void push(Character ch) {
        if (isFull()) {
            System.out.println("Stack is Full");
        } else {
            ele++;
            a[ele] = ch;
        }
    }

    public Character pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return '\0';
        } else {
            Character ch = a[ele];
            ele--;
            return ch;
        }
    }

    public boolean isEmpty() {
        return ele == -1;
    }

    public boolean isFull() {
        return ele == size - 1;
    }
}