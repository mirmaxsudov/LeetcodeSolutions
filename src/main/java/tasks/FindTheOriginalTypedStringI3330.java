package tasks;

public class FindTheOriginalTypedStringI3330 {
    public static void main(String[] args) {

    }

    public static int possibleStringCount(String word) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            for (int j = i + 1; j < word.length(); j++) {
                if (c == word.charAt(j)) {
                    count++;
                } else {
                    i = j + 1;
                    break;
                }
            }
        }

        return count;
    }
}