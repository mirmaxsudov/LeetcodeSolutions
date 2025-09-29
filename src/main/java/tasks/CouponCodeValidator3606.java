package tasks;

import java.util.*;

public class CouponCodeValidator3606 {
    public static void main(String[] args) {
        System.out.println(validateCoupons(new String[]{"SAVE20", "", "PHARMA5", "SAVE@20"}, new String[]{"restaurant", "grocery", "pharmacy", "restaurant"}, new boolean[]{true, true, true, true}));
    }

    static class Coupon implements Comparable<Coupon> {
        String code;
        int index;

        public Coupon(String code, int index) {
            this.code = code;
            this.index = index;
        }

        @Override
        public int compareTo(Coupon o) {
            int r = Integer.compare(index, o.index);
            return r == 0 ? code.compareTo(o.code) : r;
        }
    }

    public static List<String> validateCoupons(String[] codes, String[] businessLines, boolean[] isActives) {
        Map<String, Integer> lineVals = Map.of(
                "electronics", 1,
                "grocery", 2,
                "pharmacy", 3,
                "restaurant", 4
        );

        List<Coupon> coupons = new ArrayList<>();

        for (int i = 0; i < codes.length; i++) {
            String code = codes[i];
            String line = businessLines[i];
            boolean isActive = isActives[i];

            if (!isActive || !lineVals.containsKey(line) || code.isBlank() || !isValidCode(code))
                continue;

            coupons.add(new Coupon(code, lineVals.get(line)));
        }

        Collections.sort(coupons);

        return coupons.stream().map(c -> c.code).toList();
    }

    private static boolean isValidCode(String code) {
        for (char ch : code.toCharArray())
            if (!(Character.isAlphabetic(ch) || Character.isDigit(ch) || ch == '_'))
                return false;

        return true;
    }
}