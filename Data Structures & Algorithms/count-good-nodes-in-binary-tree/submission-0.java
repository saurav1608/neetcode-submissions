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
    public int goodNodes(TreeNode root) {
        return countGoodNodesUsingBfs(root);    
    }

    public int countGoodNodesUsingBfs(TreeNode root) {
        //Initialize a queue to hold node and last good node value
        Queue<List<TreeNode>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(root, root)));

        int goodNodes = 1;

        while (!queue.isEmpty()) {
            List<TreeNode> node = queue.poll();
            TreeNode nodePointer = node.get(0);
            TreeNode lastGoodNodePointer = node.get(1);
            if (nodePointer.left != null) {
                if (nodePointer.left.val >= lastGoodNodePointer.val) {
                    goodNodes+=1;
                    queue.add(new ArrayList<>(Arrays.asList(nodePointer.left, nodePointer.left)));
                } else {
                    queue.add(new ArrayList<>(Arrays.asList(nodePointer.left, lastGoodNodePointer)));
                }
            }

            if (nodePointer.right != null) {
                if (nodePointer.right.val >= lastGoodNodePointer.val) {
                    goodNodes+=1;
                    queue.add(new ArrayList<>(Arrays.asList(nodePointer.right, nodePointer.right)));
                } else {
                    queue.add(new ArrayList<>(Arrays.asList(nodePointer.right, lastGoodNodePointer)));
                }
            }
        }
        return goodNodes;
    }
}
