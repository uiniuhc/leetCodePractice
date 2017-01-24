/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null)return head;
        ListNode p=head;
        int count=1;
        while(p.next!=null){
            count++;p=p.next;
        }
        ListNode last=p;
        k=k%count;
        if(k==0) return head;
        int index=1;
        p=head;
        while(index!=count-k){
            p=p.next;
            index++;
        }
        ListNode res=p.next;p.next=null;last.next=head;
        return res;
    }
}
