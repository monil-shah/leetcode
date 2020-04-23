/*Add Two Numbers
Solution
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode sum = res;
        int carry =0;
        while(l1 !=null || l2 !=null){
            int a = (l1 != null)?l1.val:0;  // 2 for example above first iteration
            int b = (l2 != null)?l2.val:0;  //5 for example above first iteration
            int sumval = a+b+carry;
            carry = sumval/10;
            int remainder = sumval%10;
            ListNode remainder_node = new ListNode(remainder); // if remainder is in last sum
            sum.next = remainder_node;
            sum=sum.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;    
        }
        if(carry>0){ //last carry 
            ListNode carry_node = new ListNode(carry);
            sum.next = carry_node;
            sum = sum.next;
        }
        return res.next;
    }
}