class Solution {
    public int numRescueBoats(int[] people, int limit) {
        return sortAndFind(people, limit);
    }

    public int sortAndFind(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int start = 0, end = people.length - 1 ;
        while (start <= end) {
            int remainingLimit = limit - people[end];
            count+=1;
            end-=1;
            if (start <= end && remainingLimit >= people[start]) {
                start+=1;
            }
        }
        return count;
    }
}