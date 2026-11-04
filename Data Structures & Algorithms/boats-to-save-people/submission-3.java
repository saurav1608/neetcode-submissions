class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0, start = 0, end = people.length-1;
        Arrays.sort(people);
        while(start <= end) {
            boats++;
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
        }
    
        return boats;
        
    }
}