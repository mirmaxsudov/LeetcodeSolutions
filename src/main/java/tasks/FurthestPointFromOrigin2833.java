package tasks;

public class FurthestPointFromOrigin2833 {
    public static void main(String[] args) {
        System.out.println(furthestDistanceFromOrigin("L_RL__R"));
        System.out.println(furthestDistanceFromOrigin("_R__LL_"));
    }

    public static int furthestDistanceFromOrigin(String moves) {
        int left, right;
        left = right = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'L')
                left++;
            else if (c == 'R')
                right++;
        }

        return (moves.length() - (left + right)) + Math.abs(left - right);
    }
}