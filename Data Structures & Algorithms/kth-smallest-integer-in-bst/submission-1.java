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
    private int count;
    private int val;
    public int kthSmallest(TreeNode root, int k) {
        inorderHelper(root, k);
        return val;
        
    }

    public void inorderHelper(TreeNode root, int k) {
        if (root == null) return;
        inorderHelper(root.left, k);
        count+=1;
        if (count == k) {
            val = root.val;
            return;
        }
        inorderHelper(root.right, k);

    }
}
