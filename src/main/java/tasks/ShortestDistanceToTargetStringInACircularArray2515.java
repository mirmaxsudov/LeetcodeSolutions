package tasks;

public class ShortestDistanceToTargetStringInACircularArray2515 {
    public static void main(String[] args) {
        System.out.println(closestTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1));
        System.out.println(closestTarget(new String[]{"a", "b", "leetcode"}, "leetcode", 0));
        System.out.println(closestTarget(new String[]{"funmcsbcmp", "zkdrddjrcc", "sniplcjzwc", "zkdrddjrcc", "zbrrgnpftz", "icdxebphhv", "icdxebphhv", "muhwgujenj", "zkdrddjrcc", "duanbqftov"}, "funmcsbcmp", 0));
    }

    public static int closestTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target))
            return 1;

        int nextStep = -1;
        boolean nextFind = false;

        for (int i = startIndex; i < words.length; i++) {
            nextStep++;
            if (words[i].equals(target)) {
                nextFind = true;
                break;
            }
        }

        if (!nextFind) {
            for (int i = 0; i < startIndex; i++) {
                nextStep++;
                if (words[i].equals(target)) {
                    nextFind = true;
                    break;
                }
            }
        }

        if (!nextFind)
            return -1;

        int prevStep = -1;
        boolean prevFind = false;

        for (int i = startIndex; i > 0; i--) {
            prevStep++;
            if (words[i].equals(target)) {
                prevFind = true;
                break;
            }
        }

        int prevPrevStep = 0;

        if (!prevFind) {
            for (int i = words.length - 1; i > startIndex; i--) {
                prevPrevStep++;
                if (words[i].equals(target)) {
                    prevFind = true;
                    break;
                }
            }
        }

        if (!prevFind)
            return -1;

        if (prevStep == -1)
            return Math.min(prevPrevStep, nextStep);

        return Math.min(prevStep + prevPrevStep, nextStep);
    }
}