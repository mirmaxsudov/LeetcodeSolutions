package tasks;

public class DeleteColumnsToMakeSorted944 {
    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[]{"cba", "daf", "ghi"}));
        System.out.println(minDeletionSize(new String[]{"b", "a"}));
        System.out.println(minDeletionSize(new String[]{"a", "b"}));
    }

    public static int minDeletionSize(String[] strs) {
        int e = strs[0].length();
        int count = 0;

        for (int i = 0; i < e; i++) {
            char f = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) < f) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}