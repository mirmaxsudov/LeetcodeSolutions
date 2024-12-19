package tasks;

public class SplitTheArray3046 {
    public static void main(String[] args) {

    }

    public static boolean isPossibleToSplitWay3(int[] nums) {
        Boolean[] isUsed = new Boolean[101];

        for (int num : nums) {
            if (isUsed[num] == null)
                isUsed[num] = false;
            else if (isUsed[num])
                return false;
            else
                isUsed[num] = true;
        }

        return true;
    }

    public static boolean isPossibleToSplitWay2(int[] nums) {
        boolean[][] isUsed = new boolean[101][2];

        for (int num : nums) {
            boolean[] used = isUsed[num];

            if (used[0] && used[1])
                return false;

            if (used[0])
                used[1] = true;
            else
                used[0] = true;
        }

        return true;
    }

    public static boolean isPossibleToSplit(int[] nums) {
        boolean[] isUsedA = new boolean[101];
        boolean[] isUsedB = new boolean[101];

        for (int num : nums) {
            if (isUsedA[num] && isUsedB[num])
                return false;

            if (isUsedA[num])
                isUsedB[num] = true;
            else
                isUsedA[num] = true;
        }

        return true;
    }
}