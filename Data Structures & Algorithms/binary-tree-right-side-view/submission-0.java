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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //Initialize list for answer
        List<Integer> answer = new ArrayList<>();
        // Create a queue to do bfs
        Queue<TreeNode> queue = new LinkedList<>();
        //Put the root node in the queue
        queue.add(root);
    
        //Start the bfs
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size;i++) {
                TreeNode currNode = queue.poll();
                //Since elements are being added from right, the first element popped would be the rightmost element
                if (i == 0) {
                    answer.add(currNode.val);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
             }
        }
        return answer;
    }
}
