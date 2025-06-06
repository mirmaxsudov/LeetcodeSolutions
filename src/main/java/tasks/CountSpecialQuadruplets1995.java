package tasks;

public class CountSpecialQuadruplets1995 {
    public static void main(String[] args) {

    }

    public static int countQuadruplets(int[] nums) {
        int s = nums.length;
        int r = 0;

        for (int i = 0; i < s; i++) {
            for (int j = i + 1; j < s; j++) {
                for (int a = j + 1; a < s; a++) {
                    for (int k = a + 1; k < s; k++) {
                        if (nums[i] + nums[j] + nums[a] == nums[k]) {
                            r++;
                        }
                    }
                }
            }
        }

        return r;
    }
}