package tasks;

public class VowelsGameInAString3227 {
    public static void main(String[] args) {

    }

    public static boolean doesAliceWin(String s) {
        for (char c : s.toCharArray())
            if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o')
                return true;

        return false;
    }
}