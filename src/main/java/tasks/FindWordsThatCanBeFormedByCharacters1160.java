package tasks;

public class FindWordsThatCanBeFormedByCharacters1160 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static int countCharacters(String[] words, String chars) {
        int c = 0;

        t:
        for (String word : words) {
            int[] chs = new int[26];

            for (char c1 : word.toCharArray()) {
                if (c1 - 'a' > 1)
                    break t;
                chs[c1 - 'a']++;
            }

            int l = 0;

            for (char c1 : chars.toCharArray()) {
                if (chs[c1 - 'a'] == 1) {
                    chs[c1 - 'a']--;
                    l++;
                }
            }

            if (l == word.length())
                c += l;
        }

        return c;
    }
}