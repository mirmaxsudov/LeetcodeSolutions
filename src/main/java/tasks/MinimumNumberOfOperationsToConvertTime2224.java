package tasks;

public class MinimumNumberOfOperationsToConvertTime2224 {
    public static void main(String[] args) {
        System.out.println(convertTime("02:30", "04:35"));
    }

    public static int convertTime(String current, String correct) {
        int first = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3)),
                second = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3)),
                count = 0;

        while (first < second) {
            int dif = second - first;
            int adder, counter;

            if (dif / 60 != 0) {
                adder = 60 * (dif / 60);
                counter = dif / 60;
            } else if (dif / 15 != 0) {
                adder = 15 * (dif / 15);
                counter = dif / 15;
            } else if (dif / 5 != 0) {
                adder = 5 * (dif / 5);
                counter = dif / 5;
            } else {
                adder = 1;
                counter = 1;
            }

            first += adder;
            count += counter;
        }

        return count;
    }
}