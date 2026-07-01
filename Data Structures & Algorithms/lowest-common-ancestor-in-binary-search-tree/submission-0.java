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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null) {
            //if both values are greater than curr, go to right subtree
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } 
            //if both values are lesser than the curr value, go left
            else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } 
            //value found, return the curr
            else {
                return curr;
            }
        }
        return root;   
    }
}
