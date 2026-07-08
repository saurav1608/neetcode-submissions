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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //if there is no subroot, subTree relation is implicit
        if (subRoot == null) {
            return true;
        }

        //if there is no main tree, no subRoot relationship
        if (root == null) {
            return false;
        }

        if (checkTreeEquivalence(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean checkTreeEquivalence(TreeNode root, TreeNode subRoot) {
        // if both pointers have reached null, equivalence has been maintained, return true
        if (root == null && subRoot == null) return true;

        //if the two values are equivalent, continue looping
        if (root != null && subRoot != null && root.val == subRoot.val) {
            return checkTreeEquivalence(root.left, subRoot.left) && 
            checkTreeEquivalence(root.right, subRoot.right);
        }

        //no equivalence if the current pointer values are not equal
        return false;
    }
}
