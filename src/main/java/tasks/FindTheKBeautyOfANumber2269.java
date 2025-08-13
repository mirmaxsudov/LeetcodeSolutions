package tasks;

public class FindTheKBeautyOfANumber2269 {
    public static void main(String[] args) {
        System.out.println(divisorSubstrings(240, 2));
        System.out.println(divisorSubstrings(430043, 2));
        System.out.println(divisorSubstrings(10, 2));
        System.out.println(divisorSubstrings(10, 1));
        System.out.println(divisorSubstrings(30003, 3));
    }

    public static int divisorSubstrings(int num, int k) {
        int res = 0;
        int split = 10;
        int realNum = num;

        for (int i = 1; i < k; i++)
            split *= 10;


        while (num != 0) {
            int newNum = num % split;
            if (newNum != 0 && (k == 1 || (newNum >= split / 10 || num / split > 0)) && realNum % newNum == 0)
                res++;

            num /= 10;
        }

        return res;
    }
}