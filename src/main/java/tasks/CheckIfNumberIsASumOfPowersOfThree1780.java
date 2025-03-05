package tasks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckIfNumberIsASumOfPowersOfThree1780 {
    public static void main(String[] args) {
//        System.out.println(checkPowersOfThree(12));
//        System.out.println(checkPowersOfThree(91));
//        System.out.println(checkPowersOfThree(21));
//        System.out.println(checkPowersOfThree(7627));

        System.out.println(maxNumOrEqualToNum(12));
        System.out.println(maxNumOrEqualToNum(12 - 9));
    }

    public static boolean checkPowersOfThree(int n) {
        return false;
    }

    public static int maxNumOrEqualToNum(int num) {
        int powerOfThree = 1;

        while (powerOfThree * 3 < num)
            powerOfThree *= 3;

        return powerOfThree;
    }
}