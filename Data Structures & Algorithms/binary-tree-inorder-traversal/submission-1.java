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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList();
        traversalHelper(inorderList, root);
        return inorderList;
        
    }

    public void traversalHelper(List<Integer> inorderList, TreeNode root) {
        if (root == null) return;
        traversalHelper(inorderList, root.left);
        inorderList.add(root.val);
        traversalHelper(inorderList, root.right);
    }
}