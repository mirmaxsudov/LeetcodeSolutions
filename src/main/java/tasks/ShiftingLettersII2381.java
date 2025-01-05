package tasks;

public class ShiftingLettersII2381 {
    public static void main(String[] args) {
        System.out.println(shiftingLetters2("abc", new int[][]
                {
                        {0, 1, 0},
                        {1, 2, 1},
                        {0, 2, 1}
                }));
    }

    public static String shiftingLetters2(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n + 1];

        for (int[] shiftOp : shifts) {
            int start = shiftOp[0], end = shiftOp[1], direction = shiftOp[2];
            shift[start] += (direction == 1 ? 1 : -1);
            if (end + 1 < n) shift[end + 1] -= (direction == 1 ? 1 : -1);
        }

        int currentShift = 0;

        for (int i = 0; i < n; ++i) {
            currentShift += shift[i];
            shift[i] = currentShift;
        }

        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < n; ++i) {
            int netShift = (shift[i] % 26 + 26) % 26;
            result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return result.toString();
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray();

        for (int[] shift : shifts) {
            int sI = shift[0], eI = shift[1], d = shift[2];

            for (int i = sI; i <= eI; i++) {
                if (d == 1) {
                    if (chars[i] == 'z')
                        chars[i] = 'a';
                    else
                        chars[i]++;
                } else {
                    if (chars[i] == 'a')
                        chars[i] = 'z';
                    else
                        chars[i]--;
                }
            }
        }

        return new String(chars);
    }
}