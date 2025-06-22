package tasks;

public class CountDaysSpentTogether2409 {
    public static void main(String[] args) {

    }

    int[] monthdays = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = new int[366];

        readAndSet(days, arriveAlice, leaveAlice);
        readAndSet(days, arriveBob, leaveBob);

        int res = 0;

        for (int day : days)
            if (day == 2)
                res++;

        return res;
    }

    public void readAndSet(int[] days, String startDate, String endDate) {
        String[] vals1 = startDate.split("-");

        int start = monthdays[Integer.parseInt(vals1[0])];
        start += Integer.parseInt(vals1[1]);

        String[] vals2 = endDate.split("-");

        int end = monthdays[Integer.parseInt(vals2[0])];
        end += Integer.parseInt(vals2[1]);

        for (int i = start; i <= end; i++)
            days[i]++;
    }
}