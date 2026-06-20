package customIterable;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyCustomCollection collection = new MyCustomCollection();
        Iterator<String> iterator = collection.iterator();

        for (String value : collection)
            System.out.println(value);

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
