package tasks.tree;

import tasks.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree987 {
    public static void main(String[] args) {
        VerticalOrderTraversalOfABinaryTree987 main = new VerticalOrderTraversalOfABinaryTree987();
//        System.out.println(main.verticalTraversal(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(3, new TreeNode(5), new TreeNode(7)))));
//        main.verticalTraversal(new TreeNode(0,
//                new TreeNode(8), new TreeNode(1,
//                new TreeNode(3, null, new TreeNode(4, null, new TreeNode(7))))))

        System.out.println(main.verticalTraversal(new TreeNode(0,
                new TreeNode(8), new TreeNode(1,
                new TreeNode(3,
                        null, new TreeNode(4,
                        null, new TreeNode(7))), new TreeNode(2, new TreeNode(5,
                new TreeNode(6), null), null)))));
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<String, List<Integer>>> byPlaces = new HashMap<>();

        dfs(root, 0, 0, byPlaces);

        System.out.println(byPlaces);

        int[] minAndMaxValues = findMinAndMaxPlaceInMap(byPlaces);
        int min = minAndMaxValues[0], max = minAndMaxValues[1];

        List<List<Integer>> result = new ArrayList<>();

        while (min <= max) {
            Map<String, List<Integer>> mp = byPlaces.get(min);

            List<Integer> list = new ArrayList<>();

            for (Map.Entry<String, List<Integer>> listEntry : mp.entrySet()) {
                List<Integer> listEntryValue = listEntry.getValue();

                if (listEntryValue.isEmpty())
                    continue;

                if (listEntryValue.size() == 1) {
                    list.addAll(listEntryValue);
                } else {
                    Collections.sort(listEntryValue);
                    list.addAll(listEntryValue);
                }
            }

            result.add(list);

            min++;
        }

        return result;
    }

    private int[] findMinAndMaxPlaceInMap(Map<Integer, Map<String, List<Integer>>> byPlaces) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Map<String, List<Integer>>> e : byPlaces.entrySet()) {
            max = Math.max(e.getKey(), max);
            min = Math.min(e.getKey(), min);
        }

        return new int[]{min, max};
    }

    private void dfs(TreeNode root, int level, int place, Map<Integer, Map<String, List<Integer>>> byPlaces) {
        if (root == null) return;

        String key = String.valueOf(level) + place;

        Map<String, List<Integer>> mp = byPlaces.getOrDefault(place, new HashMap<>());
        List<Integer> list = mp.getOrDefault(key, new ArrayList<>());
        list.add(root.val);
        mp.put(key, list);
        byPlaces.put(place, mp);

        dfs(root.left, level + 1, place - 1, byPlaces);
        dfs(root.right, level + 1, place + 1, byPlaces);
    }
}