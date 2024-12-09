package tasks;

public class PercentageOfLetterInString2278 {
    public static void main(String[] args) {

    }

    public static int percentageLetter(String s, char letter) {
        long count = s.chars().filter(c -> c == letter).count();
        return (int) (count * 100 / s.length());
    }
}
