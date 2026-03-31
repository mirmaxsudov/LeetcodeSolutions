package tasks;

public class SerializeAndDeserializeBST449 {
    public static void main(String[] args) {

    }

    public class Codec {
        StringBuilder sb;

        public String serialize(TreeNode root) {
            sb = new StringBuilder();
            dfs(root);
            return sb.toString();
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            sb.append(root.val);
            dfs(root.right);
        }

        public TreeNode deserialize(String data) {
            return null;
        }
    }
}