package tasks;

public class DetermineIfTwoEventsHaveConflict2446 {
    public static void main(String[] args) {
        System.out.println(haveConflict(new String[]{"01:15", "02:00"}, new String[]{"02:00", "03:00"}));
    }

    public static boolean haveConflict(String[] event1, String[] event2) {
        int fsh = Integer.parseInt(event1[0].substring(0, 2)),
                fsm = Integer.parseInt(event1[0].substring(3)),
                feh = Integer.parseInt(event1[1].substring(0, 2)),
                fem = Integer.parseInt(event1[1].substring(3));

        int fs = fsh * 100 + fsm, fe = feh * 100 + fem;

        int ssh = Integer.parseInt(event2[0].substring(0, 2)),
                ssm = Integer.parseInt(event2[0].substring(3)),
                seh = Integer.parseInt(event2[1].substring(0, 2)),
                sem = Integer.parseInt(event2[1].substring(3));

        int ss = ssh * 100 + ssm, se = seh * 100 + sem;

        if (fs <= ss && fe >= ss)
            return true;

        if (fs <= se && fe >= se)
            return true;

        if (ss <= fs && se >= fs)
            return true;

        return ss <= fe && se >= fe;
    }
}