package tasks;

public class CountPairsThatFormACompleteDayI3184 {
    public static void main(String[] args) {

    }

    public static int countCompleteDayPairs(int[] hours) {
        int r = 0;

        for (int i = 0; i < hours.length; i++)
            for (int j = i + 1; j < hours.length; j++)
                if (hours[i] + hours[j] % 24 == 0)
                    r++;

        return r;
    }
}
