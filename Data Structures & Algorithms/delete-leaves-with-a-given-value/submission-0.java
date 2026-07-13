/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeafUsingRecursion(root, target);
    
    }

    public TreeNode removeLeafUsingRecursion(TreeNode root, int target) {
        //base case, current node is null
        if (root == null) return null;

        root.left = removeLeafUsingRecursion(root.left, target);
        root.right = removeLeafUsingRecursion(root.right, target);
        if (root.right == null && root.left == null && root.val == target) return null;
        return root;
    }
}