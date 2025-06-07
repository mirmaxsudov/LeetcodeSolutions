package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finding3DigitEvenNumbers2094 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findEvenNumbers(new int[]{2, 1, 3, 0})));
    }

    public static int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int[] cc = new int[10];

        for (int digit : digits)
            cc[digit]++;

        for (int i = 1; i <= 9; i++) {
            if (cc[i] == 0)
                continue;
            cc[i]--;
            for (int j = 0; j <= 9; j++) {
                if (cc[j] == 0)
                    continue;
                cc[j]--;
                for (int k = 0; k < 9; k += 2) {
                    if (cc[k] == 0)
                        continue;
                    list.add(i * 100 + j * 10 + k);
                }
                cc[j]++;
            }
            cc[i]++;
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}