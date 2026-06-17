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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList();
        traversalHelper(postOrderList, root);
        return postOrderList;
    }

    public void traversalHelper(List<Integer> postOrderList, TreeNode root) {
        if (root == null) return;
        traversalHelper(postOrderList, root.left);
        traversalHelper(postOrderList, root.right);
        postOrderList.add(root.val);
    }
}