/*
Binary Tree Zigzag Level Order Traversal
Solution
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root==null) return res;
        level(root,0,res);
        return res;
    }
    public void level(TreeNode node,int levelval,List<List<Integer>> res){
        if (levelval >= res.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            res.add(newLevel);
    } else {
      if (levelval % 2 == 0)
        res.get(levelval).add(node.val);
      else
        res.get(levelval).add(0, node.val);
    }
        if(node.left!=null){
                level(node.left,levelval+1,res);
        }
        if(node.right!=null){
                level(node.right,levelval+1,res);
        }
    }
}

//Time:O(N)  Space:O(H)