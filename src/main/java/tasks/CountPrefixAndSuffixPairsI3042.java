package tasks;

public class CountPrefixAndSuffixPairsI3042 {
    public static void main(String[] args) {

    }

    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPreAndSuf(words[j], words[i])) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isPreAndSuf(String word, String ps) {
        if (ps.length() > word.length())
            return false;

        return ps.startsWith(word) && ps.endsWith(word);
    }
}