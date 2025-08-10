package tasks;

import java.util.ArrayList;
import java.util.List;

public class CheckIfAllAsAppearsBeforeAllBs2124 {
    public static void main(String[] args) {
        CheckIfAllAsAppearsBeforeAllBs2124 obj = new CheckIfAllAsAppearsBeforeAllBs2124();
        System.out.println(obj.checkString("aaabbb"));
        System.out.println(obj.checkString("abab"));
        System.out.println(obj.checkString("bbb"));
    }

    public boolean checkString(String s) {
        return s.lastIndexOf('a') < (s.indexOf('b') == -1 ? Integer.MAX_VALUE : s.indexOf('b'));
    }
}
