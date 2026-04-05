package tasks;

public class ProductsOfArrayExceptSelf {
    public static void main(String[] args) {

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] lt = new int[nums.length];
        int[] rl = new int[nums.length];

        lt[0] = 1;

        for (int i = 1; i < nums.length; i++)
            lt[i] = lt[i - 1] * nums[i];

        rl[rl.length - 1] = 1;

        for (int i = nums.length - 1; i >= 0; i--)
            rl[i] = rl[i + 1] * nums[i];

        // 1,2,4,6

        // LR => [1, 2, 8, 24]
        // RL => [48, 48, 24, 1]

        // RS => [48, 24, 12, 8]

        // indexes for 0 => 1 & 48.

        int ln = nums.length;

        for (int i = 0; i < ln; i++)
            nums[i] = lt[i] * rl[i];

        return nums;
    }
}
