/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null||head.next.next==null)return false;
        ListNode pre=head;
        ListNode curr=head.next;
        ListNode next=head.next.next;
        pre.next=null;
        if(curr==head)return true;
        while(curr!=head &&curr!=null){
            curr.next=pre;
            pre=curr;curr=next;
            if(next!=null){
                next=next.next;
            }
            if(curr==head)return true;
        }
        return false;
    }
}
