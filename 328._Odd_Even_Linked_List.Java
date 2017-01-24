/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        if(p2==null||p2.next==null){
            return head;
        }
        ListNode even=head.next;
        ListNode p=p2.next;
        boolean odd=true;
        while(p!=null){
            if(odd){
                p1.next=p;
                p1=p1.next;
            }else{
                p2.next=p;
                p2=p2.next;
            }
            odd=!odd;
            p=p.next;
        }
        p1.next=even;
        p2.next=null;
        return head;
    }
    
    
}
