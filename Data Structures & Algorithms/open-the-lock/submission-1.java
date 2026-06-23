class Solution {
    public int openLock(String[] deadends, String target) {
        /*
        From "0000", there are 8 options
        0001, 0010, 0100, 1000, 0009, 0090, 0900, 9000
        Do a BFS adding all these values to queue except if deadend or visited
        */

        //Initialize a visited set with deadends
        Set<String> visited = new HashSet();
        for (String deadend : deadends) {
            visited.add(deadend);
        }

        //Return -1 if deadends contains the base case
        if (visited.contains("0000")) return -1;

        //Initialize a queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        //Initialize a level variable to keep track of turns
        int level = 0;

        //Iterate through queue, match if popped element equals target or add combinations to queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i<size; i++) {
                String combination = queue.poll();
                if (combination.equals(target)) return level;
                List<String> childCombinations = getAllChildren(combination);
                for (String childCombination : childCombinations) {
                    if (!visited.contains(childCombination)) {
                        visited.add(childCombination);
                        queue.offer(childCombination);
                    }
                }
            }
            level++;
        }
        return -1;    
    }

    public List<String> getAllChildren(String combination) {
        List<String> childrenCombinations = new ArrayList<>();
        for (int i=0; i<4; i++) {
            String modifiedDigitIncrement = String.valueOf(((combination.charAt(i) - '0') + 1) % 10);
            childrenCombinations.add(combination.substring(0,i) + modifiedDigitIncrement + combination.substring(i+1, 4));
            String modifiedDigitDecrement = String.valueOf(((combination.charAt(i) - '0') - 1 + 10) % 10);
            childrenCombinations.add(combination.substring(0,i) + modifiedDigitDecrement + combination.substring(i+1, 4));          
        }
        return childrenCombinations;
    }
}