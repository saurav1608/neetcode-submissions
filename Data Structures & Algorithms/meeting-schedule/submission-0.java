/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        int previousEnd = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (interval.start < previousEnd) return false;
            previousEnd = interval.end;
        }
        return true;
    }
}
