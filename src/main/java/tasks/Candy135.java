package tasks;

public class Candy135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}) + " - " + 5);
        System.out.println(candy(new int[]{1, 2, 2}) + " - " + 4);
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}) + " - " + 7);
    }

    // 1,3,2,2,1
    // 1

    public static int candy(int[] ratings) {
        int res = 0;
        int len = ratings.length;

        for (int i = 0; i < len; i++) {
            int rate = ratings[i];
            res++;

            if (i == 0) {
                if (len >= 2) {
                    if (rate > ratings[i + 1]) {
                        res++;
                    }
                }
                continue;
            }

            if (i == len - 1) {
                if (rate == ratings[i - 1])
                    continue;

                if (rate > ratings[i - 1]) {
                    res++;
                }
                continue;
            }

            if (rate == ratings[i - 1])
                continue;

            if (rate > ratings[i - 1])
                res++;
            if (rate > ratings[i + 1])
                res++;
        }

        return res;
    }
}