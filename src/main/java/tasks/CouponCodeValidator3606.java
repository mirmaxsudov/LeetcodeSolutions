package tasks;

import java.util.*;

public class CouponCodeValidator3606 {
    public static void main(String[] args) {
    }

    public static List<String> validateCoupons(String[] codes, String[] businessLines, boolean[] isActives) {
        List<String> res = new ArrayList<>();

        Map<String, List<String>> mp = new HashMap<>();

        for (String s : List.of("electronics", "grocery", "pharmacy", "restaurant"))
            mp.put(s, new ArrayList<>());

        for (int i = 0; i < codes.length; i++) {
            if (!isActives[i])
                continue;

            String code = codes[i];

            boolean isUpper, isLower, isNumber;
            isLower = isUpper = isNumber = false;

            for (char cha : code.toCharArray()) {
                if (isLower && isUpper && isNumber)
                    break;

                if (Character.isDigit(cha))
                    isNumber = true;
                else if (Character.isUpperCase(cha))
                    isUpper = true;
                else if (Character.isLowerCase(cha))
                    isLower = true;
            }

            if (isLower && isUpper && isNumber)
                continue;

            String businessLine = businessLines[i];

            mp.get(businessLine).add(code);
        }

        for (String businessLine : List.of("electronics", "grocery", "pharmacy", "restaurant")) {
            List<String> validCodes = mp.get(businessLine).stream().sorted().toList();
            res.addAll(validCodes);
        }

        return res;
    }
}