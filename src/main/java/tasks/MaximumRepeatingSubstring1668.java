package tasks;

public class MaximumRepeatingSubstring1668 {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("ababc", "ba"));
        System.out.println(maxRepeating("ababc", "ac"));
    }

    public static int maxRepeating(String sequence, String word) {
        int res = 0;
        var sb = new StringBuilder(word);

        while (sequence.contains(sb)) {
            sb.append(word);
            res++;
        }

        return res;
    }
}