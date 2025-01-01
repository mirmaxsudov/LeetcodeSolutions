package tasks;

public class CountNumberOfMaximumBitwiseORSubsets2044 {
    public static void main(String[] args) {

    }

    public static int countMaxOrSubsets(int[] nums) {
        int r = 0;

        for (int num : nums)
            r |= num;

        return r;
    }
}