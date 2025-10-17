package tasks;

public class BitwiseOROfEvenNumbersInAnArray3688 {
    public static void main(String[] args) {

    }

    public static int evenNumberBitwiseORs(int[] nums) {
        int res = 0;

        for (int num : nums)
            if ((num & 1) == 0)
                res |= num;

        return res;
    }
}