package tasks;

public class RemoveOneElementToMakeTheArrayStrictlyIncreasing1909 {
    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing(new int[]{2, 3, 1, 2}));
        System.out.println(canBeIncreasing(new int[]{1, 1}));
        System.out.println(canBeIncreasing(new int[]{1, 1, 1}));
        System.out.println(canBeIncreasing(new int[]{105, 924, 32, 968}));
    }

    public static boolean canBeIncreasing(int[] nums) {
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                flag += 1;
                if (i > 1 && nums[i - 2] >= nums[i]) {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return flag <= 1;
    }
}