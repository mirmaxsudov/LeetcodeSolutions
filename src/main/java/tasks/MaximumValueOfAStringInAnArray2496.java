package tasks;

public class MaximumValueOfAStringInAnArray2496 {
    public static void main(String[] args) {

    }

    public static int maximumValue(String[] strs) {
        int maxLen = 0;

        for (String str : strs) {
            int len = str.length();

            try {
                maxLen = Math.max(maxLen, Integer.parseInt(str));
            } catch (NumberFormatException ignored) {
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}