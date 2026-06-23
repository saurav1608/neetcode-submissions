class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

        //build an adjacency list
        for (int i = 0; i < n; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }

        for (int r = 0; r < edges.length; r++) {
            adjacencyList.get(edges[r][0]).add(edges[r][1]);
            adjacencyList.get(edges[r][1]).add(edges[r][0]);

        }

        Set<Integer> visited = new HashSet();
        int count = 0;
        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                recordConnectedNodes(adjacencyList, visited, i);
                count+=1;
            }
        }

        return count;
    }

    public void recordConnectedNodes(Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited, int i) {
        if (visited.contains(i)) return;
        
        visited.add(i);
        for (int node : adjacencyList.get(i)) {
            if (!visited.contains(node)) {
                recordConnectedNodes(adjacencyList, visited, node);
            }
        }
    }
}
