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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        //Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //breadth first search
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int qSize = queue.size();
            for (int i=0; i<qSize; i++) {
                TreeNode curr = queue.poll();
                if (curr!= null) {
                    level.add(curr.val);
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
            }
            if (level.size() > 0) {
                levelOrder.add(level);
            }    
        }

        return levelOrder;
        
    }
}
