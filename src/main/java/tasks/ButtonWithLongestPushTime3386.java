package tasks;

public class ButtonWithLongestPushTime3386 {
    public static void main(String[] args) {
        System.out.println(buttonWithLongestTime(new int[][]{{1, 2}, {2, 4}, {4, 8}}));
    }

    public static int buttonWithLongestTime(int[][] events) {
        int longestTime = events[0][0];
        int longestCal = longestTime;
        int smallestIndex = 0;

        for (int i = 1; i < events.length; i++) {
            int[] event = events[i];
            int index = event[0];
            int time = event[1];

            int cal = longestTime - time;

            if (cal == longestCal)
                continue;

            if (cal > longestCal) {
                longestCal = cal;
                smallestIndex = index;
                longestTime = time;
            }
        }

        return smallestIndex + 1;
    }
}