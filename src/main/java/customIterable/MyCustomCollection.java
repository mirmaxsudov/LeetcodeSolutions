package customIterable;

import java.util.Iterator;

public class MyCustomCollection implements Iterable<String> {
    private String[] values = {"Hello", "World", "!"};

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < values.length;
            }

            @Override
            public String next() {
                return values[index++];
            }
        };
    }
}
