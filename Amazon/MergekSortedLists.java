/*
Merge k Sorted Lists
Solution
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/





/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        if(lists.length==1)return lists[0];
        ListNode first = lists[0];
        for(int i=1;i<lists.length;i++)
        first = mergeTwoLists(first,lists[i]);
        return first;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode sort = res;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                sort.next = l1;
                l1=l1.next;
            }
            else{
                sort.next = l2;
                l2=l2.next;
            }
            sort = sort.next;
        }
        sort.next = (l1==null)?l2:l1;
        return res.next;
    }
}