/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case: if root is null, or we found either p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Divide: Look for p and q in left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // Conquer: Combine the results
        if (left != null && right != null) {
            // If p is found on one side and q on the other, current root is the LCA
            return root;
        }

        // If both are on the left, return left. If both are on the right, return right.
        return (left != null) ? left : right;
    }
}