package tasks;


import java.util.Arrays;

public class BoatsToSavePeople881 {
    public static void main(String[] args) {
//        System.out.println(numRescueBoats(
//                new int[]{1, 2}, 3
//        ));
//        System.out.println(numRescueBoats(
//                new int[]{3, 2, 2, 1}, 3
//        ));
//        System.out.println(numRescueBoats(
//                new int[]{3, 5, 3, 4}, 5
//        ));
        System.out.println(numRescueBoats(
                new int[]{3, 2, 3, 2, 2}, 6
        ));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        boolean[] visited = new boolean[people.length];

        for (int i = people.length - 1; i >= 1; i--) {
            int firstW = people[i];
            int secondW = people[i - 1];

            if (firstW + secondW > limit) {
                count++;
                visited[i] = true;
                continue;
            }

            if (firstW + secondW <= limit) {
                i -= 2;
                count++;
            }
        }

        if (visited[0])
            return count;

        if (visited[1])
            return count;

        return count + 1;
    }
}