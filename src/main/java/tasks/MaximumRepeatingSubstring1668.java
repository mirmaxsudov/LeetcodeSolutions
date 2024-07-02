package tasks;

public class MaximumRepeatingSubstring1668 {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating("ababc", "ac"));
    }

    public static int maxRepeating(String sequence, String word) {
        int count = 0;

        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.startsWith(word, i)) {
                count++;
                i += word.length() - 1;
            }
        }

        return count;
    }
}