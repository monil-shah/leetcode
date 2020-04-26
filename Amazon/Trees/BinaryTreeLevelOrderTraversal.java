/*Binary Tree Level Order Traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/




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
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return res;
        level(root,0);
        return res;  
    }
    public void level(TreeNode node, int levelval){    
        if(res.size() == levelval){
            res.add(new ArrayList<Integer>());
        }
        res.get(levelval).add(node.val);
        if(node.left!=null){
            level(node.left,levelval+1);
        }
        if(node.right!=null){
            level(node.right,levelval+1);
        }
        
    }
}

//Time:O(N) Space:O(N)