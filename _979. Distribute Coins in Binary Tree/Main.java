public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(0), new TreeNode(0));
        Solution solution = new Solution();
        System.out.println(solution.distributeCoins(treeNode));
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int totalMoves;

    public int distributeCoins(TreeNode root) {
        totalMoves = 0;
        helper(root);
        return totalMoves;
    }

    public int helper(TreeNode node) {
        if (node == null)
            return 0;

        int leftMoves = helper(node.left);
        int rightMoves = helper(node.right);

        totalMoves += Math.abs(leftMoves) + Math.abs(rightMoves);

        return (leftMoves + rightMoves + node.val - 1);
    }
}