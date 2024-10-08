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
        List<Integer> indexesOfA = new ArrayList<>();
        List<Integer> indexesOfB = new ArrayList<>();
        int index = 0;

        for (char cha : s.toCharArray()) {
            if (cha == 'a') {
                indexesOfA.add(s.indexOf(cha));

                for (Integer i : indexesOfB)
                    if (i < index)
                        return false;
            } else if (cha == 'b') {
                indexesOfB.add(s.indexOf(cha));

                for (Integer i : indexesOfA)
                    if (i < index)
                        return false;
            }
        }
        
        return true;
    }
}
