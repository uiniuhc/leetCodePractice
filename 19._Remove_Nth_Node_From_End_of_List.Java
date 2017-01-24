/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || n==0)return head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode pslow=null;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null)return head.next;
        while(fast!=null){
           fast=fast.next;
           pslow=slow;
           slow=slow.next;
        }
        pslow.next=slow.next;
        
        return head;
        
    }

}
