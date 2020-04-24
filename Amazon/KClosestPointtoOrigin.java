/*
K Closest Points to Origin

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 

Note:

1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000
*/


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Map<Integer,Integer> distance = new HashMap<Integer,Integer>();
        for(int i=0;i<points.length;i++){
            int dist = euclidean(points[i]);
            distance.put(i,dist);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2)->(distance.get(n2)-distance.get(n1)));
        for(int p : distance.keySet()){
            heap.add(p);
            if(heap.size()>K){
                heap.poll();
            }
        }
        int[][] res = new int[K][2];
        int counter = K-1;
        while(!heap.isEmpty()){
            res[counter] = points[heap.poll()];
            counter--;
        }
    return res;
    }
    public int euclidean(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}

// Time; O(nlog(n)) Space: O(n)