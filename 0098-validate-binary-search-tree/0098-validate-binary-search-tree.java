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
    public boolean isValidBST(TreeNode root) {
        // Start with the widest possible range
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // An empty tree is a valid BST
        if (node == null) {
            return true;
        }

        // The current node's value must be strictly within (min, max)
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively validate subtrees with updated ranges
        // For left: max becomes the current node's value
        // For right: min becomes the current node's value
        return validate(node.left, min, node.val) && 
               validate(node.right, node.val, max);
    }
}