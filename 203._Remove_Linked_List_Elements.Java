/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return head;
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null && curr.val==val){
            curr=curr.next;
        }
        if(curr==null)return curr;
        head=curr;
        pre=curr;
        curr=curr.next;
        while(curr!=null){
            if(curr.val==val){pre.next=curr.next;curr=curr.next;}
            else{
                pre=curr;curr=curr.next;
            }
        }
        return head;
    }
}
