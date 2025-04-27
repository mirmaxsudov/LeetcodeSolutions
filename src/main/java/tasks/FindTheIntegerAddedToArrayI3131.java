package tasks;

public class FindTheIntegerAddedToArrayI3131 {
    public static void main(String[] args) {

    }

    public static int addedInteger(int[] nums1, int[] nums2) {
        int m1 = nums1[0];
        int m2 = nums2[0];

        for (int i = 0; i < nums1.length; i++) {
            m1 = Math.min(nums1[i], m1);
            m2 = Math.min(nums2[i], m2);
        }

        return m2 - m1;
    }
}