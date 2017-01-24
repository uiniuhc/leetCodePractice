/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode a=head;
        ListNode b=head.next;
        ListNode next=swapPairs(b.next);
        a.next=next;
        b.next=a;
        return b;
    }
}
