/**
 * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
 * <p>
 * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value target, it should also be deleted (you need to continue doing that until you cannot).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,3,2,null,2,4], target = 2
 * Output: [1,null,3,null,4]
 * Explanation: Leaf nodes in green with value (target = 2) are removed (Picture in left).
 * After removing, new nodes become leaf nodes with value (target = 2) (Picture in center).
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(3, new TreeNode(3), new TreeNode(2)), new TreeNode(3));
        Solution solution = new Solution();
        solution.removeLeafNodes(treeNode, 3);
    }
}


class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null)
            return null;

        return root;
    }
}