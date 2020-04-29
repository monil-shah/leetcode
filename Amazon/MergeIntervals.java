/*
 Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/



class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>(){
           public int compare(int[] i1, int[] i2){
               return i1[0] - i2[0];
           } 
        }); 
        List<int[]> res = new ArrayList();
        int count = 0;
        int[] curr = intervals[0];
        res.add(curr);
        for(int[] interval : intervals){
            int curr_begin = curr[0];
            int curr_end = curr[1];
            int next_begin = interval[0];
            int next_end = interval[1];
            if(curr_end>=next_begin){
                curr[1] = Math.max(curr_end,next_end);     /// changes in output arraylist res.        
            }
            else{
                curr = interval;
                res.add(curr);
            }
            }
        return res.toArray(new int[res.size()][]);
    }
}