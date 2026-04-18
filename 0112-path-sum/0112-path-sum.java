/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 1. Base case: If root is null, no path exists
        if (root == null) {
            return false;
        }

        // 2. Leaf node check: If current node is a leaf, 
        // compare its value to the remaining sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 3. Recursive step: Subtract current value and check children
        int remainingSum = targetSum - root.val;
        
        return hasPathSum(root.left, remainingSum) || 
               hasPathSum(root.right, remainingSum);
    }
}