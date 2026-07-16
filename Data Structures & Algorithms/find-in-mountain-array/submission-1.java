/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    //Initialize a hash map to fetch values which have already been fetched from the API
    private Map<Integer, Integer> cache = new HashMap<>();

    public int findInMountainArray(int target, MountainArray mountainArray) {
        int arrayLength = mountainArray.length();
        
        //find pivot
        int pivot = findMountainPeak(mountainArray, arrayLength);

        int elementAtPivot = getElementAtIndex(mountainArray, pivot);

        //return pivot if it is the target
        if (elementAtPivot == target) return pivot;

        //try finding the element to the left of pivot
        int res = binarySearch(mountainArray, 0, pivot - 1, true, target);
        //return the result if the target was found
        if (res != -1) return res;

        //if not found in left, try looking for it to the right of pivot
        return binarySearch(mountainArray, pivot + 1, arrayLength - 1, false, target);        
    }

    /**
    Find the index at which the array pivots to go down
    We take a pair of three elements mid - 1, mid and mid + 1
    If they are increasing, pivot is on right, 
    If they are decreasing, pivot is on the left of mid
    Else, the current element is the pivot
    **/
    public int findMountainPeak (MountainArray array, int arrayLength) {
        int left = 1, right = arrayLength - 2, peak = 0;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int prevEle = getElementAtIndex(array, mid - 1);
            int midEle = getElementAtIndex(array, mid);
            int nextEle = getElementAtIndex(array, mid+1);
            if (prevEle < midEle && midEle < nextEle) left = mid + 1;
            else if (prevEle > midEle && midEle > nextEle) right = mid - 1;
            else {
                peak = mid;
                break;
            } 
        }
        return peak;
    }

    /**
    Method to get value from MountainArray at a particular given index
    The value would first be checked in the cache
    If not found, the API would be called, value would be returned and stored in the cache
    **/
    public int getElementAtIndex(MountainArray array, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        } else {
            int value = array.get(index);
            cache.put(index, value);
            return value;
        }
    }

    /**
    Perform a binary search 
    **/
    public int binarySearch(MountainArray array, int left, int right, boolean isAscending, int target) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            int elementAtMid = getElementAtIndex(array, mid);
            if (elementAtMid == target) return mid;
            else if (target > elementAtMid) {
                if (isAscending) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (isAscending) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}