package tasks;

public class NumberOfEmployeesWhoMetTheTarget2798 {
    public static void main(String[] args) {

    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        for (int hour : hours)
            if (hour >= target)
                count++;

        return count;
    }
}