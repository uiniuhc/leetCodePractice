/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)return head;
        ListNode before=null;
        ListNode blast=null;
        ListNode after=null;
        ListNode alast=null;
        ListNode p=head;
        ListNode next=null;
        while(p!=null){
            next=p.next;
            p.next=null;
            if(p.val>=x){
                //append p into after
                if(after==null){after=p;alast=p;}
                else{alast.next=p;alast=alast.next;}
            }else{
                if(before==null){before=p;blast=p;}
                else{blast.next=p;blast=blast.next;}
            }
            p=next;
        }
        if(before==null)return after;
        blast.next=after;
        return before;
    }
    
}
