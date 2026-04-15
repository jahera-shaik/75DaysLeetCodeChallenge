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
    public int maxDepth(TreeNode root) {
        // Base case: If the node is null, depth is 0
        if (root == null) {
            return 0;
        }
        
        // Recursive calls to find the height of left and right subtrees
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        
        // The current node's depth is 1 + the max of its children's depths
        return 1 + Math.max(leftHeight, rightHeight);
    }
}