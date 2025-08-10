package tasks;

public class HexadecimalAndHexatrigesimalConversion3602 {
    public static void main(String[] args) {

    }

    public static String concatHex36(int n) {
        return (Integer.toString(n * n, 16) + Integer.toString(n * n * n, 36)).toUpperCase();
    }
}
