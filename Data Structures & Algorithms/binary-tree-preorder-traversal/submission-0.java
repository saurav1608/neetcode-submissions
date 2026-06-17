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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList();
        traversalHelper(preOrderList, root);
        return preOrderList;
    }

    public void traversalHelper(List<Integer> preOrderList, TreeNode root) {
        if (root==null) return;
        preOrderList.add(root.val);
        traversalHelper(preOrderList, root.left);
        traversalHelper(preOrderList, root.right);
    }
}