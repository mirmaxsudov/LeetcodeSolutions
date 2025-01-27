package tasks;

public class PermutationDifferenceBetweenTwoStrings3146 {
    public static void main(String[] args) {
        System.out.println(findPermutationDifference("abcd", "bcda") + " - " + 0);
    }

    public static int findPermutationDifference(String s, String t) {
        int sum = 0;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a'] = i;

        for (int i = 0; i < t.length(); i++)
            sum += Math.abs(freq[t.charAt(i) - 'a'] - i);

        return sum;
    }
}