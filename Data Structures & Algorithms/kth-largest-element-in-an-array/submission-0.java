class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestUsingHeap(nums, k);
    }

    public int findKthLargestUsingHeap(int[] nums, int k) {
        //Create a max heap to store k largest elements
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        for (int num : nums) {
            heap.offer(num);
        }

        int answer= 0;
        while (k != 0) {
            answer = heap.poll();
            k --;
        }
        return answer;

    }
}
