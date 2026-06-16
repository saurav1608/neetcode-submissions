class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        arr = [0] * (2*len(nums));
        for i,num in enumerate(nums) :
            arr[i] = num;
            arr[i+len(nums)] = num;
        return arr;