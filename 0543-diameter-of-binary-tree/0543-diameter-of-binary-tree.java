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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively find the height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update the global maximum diameter
        // Diameter at this node = leftHeight + rightHeight
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

        // Return the height of the current node to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}