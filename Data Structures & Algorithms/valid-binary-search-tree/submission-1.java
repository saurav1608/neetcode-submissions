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
    public boolean isValidBST(TreeNode root) {
        //Check whether inorder list is sorted
        List<Integer> inorder = new ArrayList<>();
        traversalHelper(inorder, root);
        return isSorted(inorder);
        
    }

    public void traversalHelper(List<Integer> inorderList, TreeNode root) {
        if (root == null) return;
        traversalHelper(inorderList, root.left);
        inorderList.add(root.val);
        traversalHelper(inorderList, root.right);
    }

    public boolean isSorted(List<Integer> inorder) {
        for (int i = 1; i<inorder.size();i++) {
            if (inorder.get(i) <= inorder.get(i-1)) {
                return false;
            }
        }
        return true;
    }
}
