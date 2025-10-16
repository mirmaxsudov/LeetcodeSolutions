package tasks;

public class ComputeAlternatingSum3701 {
    public static void main(String[] args) {

    }

    public static int alternatingSum(int[] nums) {
        int sum = 0;
        boolean isEven = true;

        for (int num : nums) {
            sum += (isEven ? num : -num);
            isEven = !isEven;
        }

        return sum;
    }
}
