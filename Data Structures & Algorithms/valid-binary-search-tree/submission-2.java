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
        // List<Integer> inorder = new ArrayList<>();
        // traversalHelper(inorder, root);
        // return isSorted(inorder);

        //Check using bounds
        return checkUsingBounds(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
        
    }

    public boolean checkUsingBounds(int left, int right, TreeNode root) {
        //if the node is empty, the bst is valid
        if (root == null) return true;

        //case where the node is not between bounds, return false
        if (!((root.val > left) && (root.val < right))) return false;

        /*
        Check whether right and left subtrees are valid
        For the left subtree, the upper bound would be the current node
        For the right subtree, the lower bound would be the current node
        */
        return checkUsingBounds(left, root.val, root.left) &&
        checkUsingBounds(root.val, right, root.right);
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
