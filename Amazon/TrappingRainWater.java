/*
Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/


class Solution {
    public int trap(int[] height) {
        int area = 0 ;
        int l = 0;
        int l_max=0;
        int r_max=0;
        int r = height.length-1;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l] >= l_max) l_max=height[l];
                else area+=(l_max-height[l]);
                l++;
            }
            else{
                if(height[r]>=r_max) r_max=height[r];
                else area+=(r_max-height[r]);
                r--;
            }
        }
        return area;
    }
}

//Time: O(n) Space: O(1)