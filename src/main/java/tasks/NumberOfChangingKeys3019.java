package tasks;

public class NumberOfChangingKeys3019 {
    public static void main(String[] args) {

    }

    public int countKeyChanges(String s) {
        int count = 0;
        char cChar = s.charAt(0);

        for (char ch : s.toCharArray()) {
            if (ch != cChar) {
                count++;
                cChar = ch;
            }
        }

        return count;
    }
}
