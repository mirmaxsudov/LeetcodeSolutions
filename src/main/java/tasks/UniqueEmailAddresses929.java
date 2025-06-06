package tasks;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses929 {
    public static void main(String[] args) {
        String[] st = {"test.email+alex@leetcode.com", "test.email@leetcode.com"};
//        String[] st = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(st));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> st = new HashSet<>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();

            for (char c : email.toCharArray()) {
                if (c == '@') {
                    sb.append(email.substring(email.lastIndexOf('@')));
                    break;
                }

                if (c != '.' && c != '+')
                    sb.append(c);
                else {
                    if (c == '+') {
                        sb.append(email.substring(email.lastIndexOf('@')));
                        break;
                    }
                }
            }

            if (!sb.isEmpty())
                st.add(sb.toString());
        }

        return st.size();
    }
}