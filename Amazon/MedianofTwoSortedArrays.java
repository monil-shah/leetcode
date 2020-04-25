/*Median of Two Sorted Arrays
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double res = 0;
      //  int[] nums = new int[nums1.length+nums2.length];
        List<Double> nums = new ArrayList<Double>();

        for(int num1:nums1){
            nums.add((double)num1);
        }
        for(int num2:nums2){
            nums.add((double)num2);
        }
        Collections.sort(nums);
        int len = nums.size();
        if(len%2==0){
            res = (nums.get((len/2))+nums.get((len/2)-1))/2;
        }
        else{
            res = nums.get(((len+1)/2)-1);
        }
        return res;
    }
}

//Time: O(n) Space: O(n)