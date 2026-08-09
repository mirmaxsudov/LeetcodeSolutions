package tasks;

import java.util.HashMap;
import java.util.Map;

public class SerializeAndDeserializeBST449 {
    public static void main(String[] args) {

    }

    public class Codec {
        Map<String, TreeNode> mp = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        public String serialize(TreeNode root) {
            if (root == null) return null;
            dfs(root);
            mp.put(sb.toString(), root);
            return sb.toString();
        }

        private void dfs(TreeNode root) {
            if (root == null)
                return;
            dfs(root.left);
            sb.append(root.val).append(",");
            dfs(root.right);
        }

        public TreeNode deserialize(String data) {
            return mp.getOrDefault(data, null);
        }
    }
}