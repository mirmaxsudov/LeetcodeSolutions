package tasks;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes1784 {
    public static void main(String[] args) {

    }

    public static boolean checkOnesSegmentVer2(String s) {
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) == '0' && s.charAt(i + 1) == '1')
                return false;

        return true;
    }

    public static boolean checkOnesSegment(String s) {
        boolean isFind = false;
        boolean isStart = false;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                if (!isStart)
                    isStart = true;
            } else {
                if (isFind && isStart)
                    return false;

                isFind = true;
                isStart = false;
            }
        }

        return isFind;
    }
}