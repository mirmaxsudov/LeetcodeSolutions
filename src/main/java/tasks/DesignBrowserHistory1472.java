package tasks;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory1472 {
    public static void main(String[] args) {

    }

    static class BrowserHistory {
        static class Node {
            String val;
            Node next;
            Node prev;

            public Node(String val) {
                this.val = val;
            }
        }

        private List<String> list;
        private int currentIndex;

        public BrowserHistory(String homepage) {
            list = new ArrayList<>();
            list.add(homepage);
            currentIndex = 0;
        }

        public void visit(String url) {
            list.add(url);
        }

        public String back(int steps) {
            try {
                return list.get(currentIndex - steps);
            } catch (Exception e) {
                return list.getFirst();
            }
        }

        public String forward(int steps) {
            try {
                return list.get(currentIndex + steps);
            } catch (Exception e) {
                return list.getFirst();
            }
        }
    }
}