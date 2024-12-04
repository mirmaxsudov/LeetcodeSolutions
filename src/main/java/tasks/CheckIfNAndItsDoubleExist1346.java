package tasks;

public class CheckIfNAndItsDoubleExist1346 {
    public static void main(String[] args) {
        System.out.println(checkIfExist2(new int[]{10, 2, 5, 3}));
    }

    public static boolean checkIfExist2(int[] array) {
        int[] dp = new int[2001];
        for (int x : array) {
            if (x < 0)
                dp[1000 - x]++;
            else
                dp[x]++;
        }
        for (int i = 2; i < 1001; i += 2)
            if ((dp[i] > 0 && dp[i / 2] > 0) || (dp[1000 + i] > 0 && dp[1000 + i / 2] > 0))
                return true;

        return dp[0] > 1;
    }

    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[i] * 2 == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}