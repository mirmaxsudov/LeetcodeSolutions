package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindIndicesOfStableMountains3285 {
    public static void main(String[] args) {
        System.out.println(stableMountains(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public static List<Integer> stableMountainsVer2(int[] height, int threshold) {
        return IntStream.range(0, height.length - 1)
                .filter(i -> height[i] > threshold)
                .map(i -> i + 1)
                .boxed()
                .toList();
    }

    public static List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < height.length - 1; i++)
            if (height[i] > threshold)
                res.add(i + 1);


        return res;
    }
}