package tasks;

public class SpecialArrayI3151 {
    public static void main(String[] args) {

    }

    public static boolean isArraySpecial(int[] nums) {
        if (nums.length <= 1)
            return true;

        for (int i = 1; i < nums.length; i++)
            if ((nums[i] & 1) == (nums[i] & 1))
                return false;

        return true;
    }
}