class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestUsingHeap(nums, k);
    }

    public int findKthLargestUsingHeap(int[] nums, int k) {
        //Create a max heap to store k largest elements
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
