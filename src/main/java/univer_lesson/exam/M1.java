package univer_lesson.exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class M1 {
    public static void main(String[] args) {
        BinaryNumbers binaryNumbers = new BinaryNumbers();
        System.out.println(binaryNumbers.generate(20));
    }
    static class BinaryNumbers {
        public List<String> generate(int N) {
            List<String> res = new ArrayList<>();
            Queue<String> q = new LinkedList<>();
            q.add("1");
            for (int i = 0; i < N; i++) {
                String s = q.poll();
                res.add(s);
                q.add(s + "0");
                q.add(s + "1");
            }
            return res;
        }
    }
}