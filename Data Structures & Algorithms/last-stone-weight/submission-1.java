class Solution {
    public int lastStoneWeight(int[] stones) {
        // Create a max heap from the array
        List<Integer> stonesList = Arrays.stream(stones).boxed().toList();
        PriorityQueue<Integer> heap = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        heap.addAll(stonesList);
        while (heap.size() > 1) {
            int heaviest = heap.poll();
            int secondHeaviest = heap.poll();
            heap.offer(heaviest - secondHeaviest);

        }
        return heap.peek();
    }
}
