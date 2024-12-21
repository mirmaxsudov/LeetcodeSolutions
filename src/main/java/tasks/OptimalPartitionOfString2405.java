package tasks;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfString2405 {
    public static void main(String[] args) {

    }

    public int partitionString(String s) {
        int count = 0;
        Set<Character> ch = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (ch.contains(c)){
                count++;
                ch.clear();
            }

            ch.add(c);
        }

        return count;
    }
}