package tasks;

public class CountTheNumberOfSpecialCharactersI3120 {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC"));
    }

    public static int numberOfSpecialChars(String word) {
        boolean[][] bt = new boolean[28][2];

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                bt[c - 'A'][0] = true;
            } else {
                bt[c - 'a'][1] = true;
            }
        }

        int count = 0;

        for (boolean[] b : bt)
            if (b[0] && b[1])
                count++;

        return count;
    }
}