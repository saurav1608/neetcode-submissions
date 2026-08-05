class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Points as int[]{x, y}, ordered by distance to origin — nearest first
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            Comparator.comparingInt((int[] p) -> p[0]*p[0] + p[1]*p[1]).reversed());

        for(int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.toArray(new int[0][]);
    }
}
