package tasks;

import java.util.Arrays;

public class BackspaceStringCompare844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String s, String t) {
        boolean[] isUsedF = new boolean[s.length()];
        boolean[] isUsedS = new boolean[t.length()];

        char[] charsF = s.toCharArray();
        char[] charsS = t.toCharArray();

        for (int i = 0; i < charsF.length; i++) {
            if (charsF[i] == '#') {
                isUsedF[i] = true;

                for (int j = i - 1; j >= 0; j--) {
                    if (Character.isAlphabetic(charsF[j]) && !isUsedF[j]) {
                        isUsedF[j] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < charsS.length; i++) {
            if (charsS[i] == '#') {
                isUsedS[i] = true;

                for (int j = i - 1; j >= 0; j--) {
                    if (Character.isAlphabetic(charsS[j]) && !isUsedS[j]) {
                        isUsedS[j] = true;
                        break;
                    }
                }
            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (int i = 0; i < isUsedF.length; i++) {
            if (!isUsedF[i]) {
                sb1.append(charsF[i]);
            }
        }

        for (int i = 0; i < isUsedS.length; i++) {
            if (!isUsedS[i]) {
                sb2.append(charsS[i]);
            }
        }

        return sb1.toString().contentEquals(sb2);
    }
}