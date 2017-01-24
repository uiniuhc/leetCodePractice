/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2==null)return l1;
        if(l1==null)return l2;
        ListNode head,tail,p1=l1,p2=l2;
        if(l1.val<l2.val){
            head=l1;p1=p1.next;tail=head;
        }else{
            head=l2;p2=p2.next;tail=head;
        }
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                tail.next=p1;p1=p1.next;tail=tail.next;
            }else{
                tail.next=p2;p2=p2.next;tail=tail.next;
            }
        }
        while(p1!=null){
            tail.next=p1;p1=p1.next;tail=tail.next;
        }
        while(p2!=null){
            tail.next=p2;p2=p2.next;tail=tail.next;
        }
        tail.next=null;
        return head;
        
    }
}
