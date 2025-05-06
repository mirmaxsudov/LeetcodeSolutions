package univerLesson.DS;

import lombok.ToString;
import tasks.TreeNode;

import java.util.*;

public class Task05062025 {
    public static void main(String[] args) {
        System.out.println(findKithMinimumElement(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 4));

        TreeNode root = new TreeNode(4,
                null, new TreeNode(30,
                new TreeNode(13), null));

//        System.out.println(findMaxDepthOfTree(root));
//
        System.out.println(inOrderWithIterativeWay(root));

        int[] array = {4, 1, 5, 7, 89, 123, 4, 685322, 32, 451};
//        selectionSort(array);
//        System.out.println("array = " + Arrays.toString(array));

//        System.out.println(isPalindromeWithStack("ava"));
//        System.out.println(isPalindromeWithStack("avva"));
//        System.out.println(isPalindromeWithStack("avbava"));

//        System.out.println(isBalancedBrackets("{[()()]}"));

//        scheduleTasks(List.of(
//                new TaskScheduled(4, "Task 1"),
//                new TaskScheduled(1, "Task 2")
//        ));
    }

    public static void scheduleTasks(List<TaskScheduled> tasks) {
        PriorityQueue<TaskScheduled> scheduledTasks = new PriorityQueue<>();
        scheduledTasks.addAll(tasks);
        System.out.println(scheduledTasks);
    }

    public static boolean isBalancedBrackets(String str) {
        Stack<Character> st = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '[' || c == '{' || c == '(')
                st.push(c);
            else {
                if (c == ']') {
                    if (st.isEmpty() || st.pop() != '[')
                        return false;
                } else if (c == '}') {
                    if (st.isEmpty() || st.pop() != '{')
                        return false;
                } else if (c == ')') {
                    if (st.isEmpty() || st.pop() != '(')
                        return false;
                }
            }
        }

        return st.isEmpty();
    }

    public static boolean isPalindromeWithStack(String str) {
        Stack<Character> st = new Stack<>();

        for (char ch : str.toCharArray())
            st.add(ch);

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != st.pop())
                return false;

        return true;
    }

    public static void mergeSort(int[] array) {
        int len = array.length;
        int middle = len / 2;

        if (middle < 2)
            return;

        int[] left = new int[middle];
        int[] right = new int[len - middle];

        System.arraycopy(array, 0, left, 0, middle);

        if (len - middle >= 0) System.arraycopy(array, middle, right, 0, len - middle);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    public static void merge(int[] res, int[] left, int[] right) {
        int index = 0, leftIndex = 0, rightIndex = 0;
        int leftLen = left.length, rightLen = right.length;

        while (leftLen > leftIndex && rightLen > rightIndex) {
            int leftVal = left[leftIndex];
            int rightVal = right[rightIndex];

            if (leftVal <= rightVal) {
                res[index] = leftVal;
                leftIndex++;
            } else {
                res[index] = rightVal;
                rightIndex++;
            }

            index++;
        }

        for (int i = leftIndex; i < leftLen; i++)
            res[index++] = left[i];

        for (int i = rightIndex; i < rightLen; i++)
            res[index++] = right[i];
    }

    public static void selectionSort(int[] arr) {
        int min;
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int val = arr[min];
            arr[min] = arr[i];
            arr[i] = val;
        }
    }

    public static List<Integer> inOrderWithIterativeWay(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }

            root = st.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }

    public static int findMaxDepthOfTree(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int depth) {
        if (root == null)
            return depth;

        return Math.max(
                dfs(root.left, depth + 1),
                dfs(root.right, depth + 1)
        );
    }

    public static int findKithMinimumElement(int[] array, int k) {
        PriorityQueue<Integer> pr = new PriorityQueue<>();

        for (int num : array)
            pr.add(num);

        for (int i = 0; i < k - 1; i++)
            pr.poll();

        return pr.poll();
    }
}

@ToString
class TaskScheduled implements Comparable<TaskScheduled> {
    Integer priority;
    String task;

    public TaskScheduled(int pr, String task) {
        this.priority = pr;
        this.task = task;
    }

    @Override
    public int compareTo(TaskScheduled o) {
        return this.priority.compareTo(o.priority);
    }
}