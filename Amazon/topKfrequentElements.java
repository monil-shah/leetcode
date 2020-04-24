/*
Top K Frequent Elements
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.
*/



class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int i:nums){
            if(!freq.containsKey(i)){
                freq.put(i,1);
            }
            else{
                freq.put(i,freq.get(i)+1);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2)->(freq.get(n1)-freq.get(n2)));
        for(int key:freq.keySet()){
            heap.add(key);
            if(heap.size()>k){
                heap.poll();
            }
        }
        List<Integer> top = new ArrayList<Integer>();
        int counter = k-1;
        while(!heap.isEmpty()){
            res[counter] = heap.poll();
            counter--;
        }
        
       return res;
    }
}

// Time: O(nlog(k))  and space: O(n)