package tasks.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decimalRepresentation(537)));
    }

    public static int[] decimalRepresentation(int n) {
        String str = String.valueOf(n);
        int ri = 0;
        int count = 0;

        for (char c : str.toCharArray())
            if (c != '0')
                count++;

        int[] res = new int[count];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                continue;

            res[ri] = (Integer.parseInt(str.charAt(i) + "0".repeat(str.length() - 1 - i)));
        }

        return res;
    }
}


/*

1 => 1
31 => 30, 1
40041 => 40000, 40, 1








*/
