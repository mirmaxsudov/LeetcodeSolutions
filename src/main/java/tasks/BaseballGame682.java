package tasks;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame682 {
    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    public static int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String operation : operations) {
            int size = list.size();

            switch (operation) {
                case "+" -> {
                    if (list.isEmpty()) {
                        list.add(0);
                    } else {
                        if (size == 1) {
                            list.add(list.getLast());
                        } else {
                            list.add(list.getLast() + list.get(size - 2));
                        }
                    }
                }
                case "D" -> {
                    if (list.isEmpty()) {
                        list.add(0);
                    } else {
                        list.add(list.getLast() * 2);
                    }
                }
                case "C" -> {
                    if (list.isEmpty())
                        continue;

                    list.removeLast();
                }
                default -> {
                    list.add(Integer.parseInt(operation));
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
