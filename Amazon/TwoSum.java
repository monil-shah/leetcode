/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

//Solution:

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> resMap = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i =0; i < nums.length; i++){
            int remainder = target - nums[i];
            Integer getVal = resMap.get(remainder);
           
            if(getVal != null){
                return new int[]{getVal,i};
            }
            else{
                resMap.put(nums[i], i);
            }
        }
        return res;
    }
}