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
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root)[0] == 1;
        
    }

    public int[] checkBalance(TreeNode root) {
        //Base case, root is null, tree is balanced
        if (root == null) {
            return new int[]{1,0};
        }

        //find whether left and rights trees are balanced, and the height
        int[] left = checkBalance(root.left);
        int[] right = checkBalance(root.right);

        /*
        Starting from current root, the tree is balance if,
            - the left and right subtrees are balanced
            - the depths of the left and right subtrees don't differ by greater that 1 
        */
        boolean isRootBalanced = (left[0] == 1 &&
        right[0] == 1 &&
        Math.abs(left[1] - right[1]) <= 1);

        //the depth of current root is the max of the two children + 1
        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{isRootBalanced ? 1 : 0, height}; 
    }
}
