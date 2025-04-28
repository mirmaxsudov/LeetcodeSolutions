package tasks;

public class NumberOfStudentsDoingHomeworkAtAGivenTime1450 {
    public static void main(String[] args) {

    }

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int r = 0;

        for (int i = 0; i < startTime.length; i++)
            if (startTime[i] >= queryTime && endTime[i] <= queryTime)
                r++;

        return r;
    }
}