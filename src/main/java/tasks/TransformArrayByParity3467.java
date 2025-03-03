package tasks;

public class TransformArrayByParity3467 {
    public static void main(String[] args) {

    }

    public static int[] transformArray(int[] nums) {
        int[] res = new int[nums.length];
        int l = 0, r = nums.length - 1;

        for (int num : nums)
            if (num % 2 == 0)
                res[l++] = 0;
            else
                res[r--] = 1;

        return res;
    }
}