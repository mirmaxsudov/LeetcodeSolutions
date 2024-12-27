package tasks.yandex;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        int n = 7;

        int[] a = {7, 6, 1, 2, 3, 4, 5};
        int[] b = {7, 4, 3, 1, 1, 5, 5};
        int[] c = {2, 6, 5, 4, 1, 7, 3};

        System.out.println(minYearsToDelete(n, a, b, c));
    }

    public static int minYearsToDelete(int N, int[] A, int[] B, int[] C) {
        Set<Integer> E = new HashSet<>();
        for (int val : A) E.add(val);

        Set<Integer> B_set = new HashSet<>();
        for (int val : B) B_set.add(val);

        Set<Integer> C_set = new HashSet<>();
        for (int val : C) C_set.add(val);

        E.retainAll(B_set);
        E.retainAll(C_set);

        Set<Integer> prevE = new HashSet<>();
        while (!E.equals(prevE)) {
            prevE = new HashSet<>(E);
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < N; i++)
                if (E.contains(A[i]))
                    indices.add(i);

            Set<Integer> A_events = new HashSet<>();
            Set<Integer> B_events = new HashSet<>();
            Set<Integer> C_events = new HashSet<>();

            for (int i : indices) {
                A_events.add(A[i]);
                B_events.add(B[i]);
                C_events.add(C[i]);
            }

            E = new HashSet<>(A_events);
            E.retainAll(B_events);
            E.retainAll(C_events);
        }

        int deletions = 0;

        for (int i = 0; i < N; i++)
            if (!E.contains(A[i]))
                deletions++;

        return deletions;
    }
}