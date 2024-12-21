package tasks;

public class CheckIfTwoChessboardSquaresHaveTheSameColor3274 {
    public static void main(String[] args) {
        System.out.println(checkTwoChessboards("a1", "c3"));
    }

    public static boolean checkTwoChessboards(String c1, String c2) {
        return ((c1.charAt(0) - 'a' + (c1.charAt(1) - '0')) & 1) ==
                ((c2.charAt(0) - 'a' + c2.charAt(1) - '0') & 1);
    }
}