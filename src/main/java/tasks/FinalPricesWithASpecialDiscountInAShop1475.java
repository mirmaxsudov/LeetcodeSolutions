package tasks;

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop1475 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices2(new int[]{8, 4, 6, 2, 3})));
    }

    public static int[] finalPrices2(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int len = prices.length;

        int[] res = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            int discount = 0;

            if (!stack.isEmpty()) {
                discount = stack.peek();
            }

            res[i] = prices[i] - discount;

            stack.push(prices[i]);
        }

        return res;
    }

    public static int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++)
            for (int j = i + 1; j < prices.length; j++)
                if (prices[j] <= prices[i]) {
                    prices[i] -= prices[j];
                    break;
                }

        return prices;
    }
}