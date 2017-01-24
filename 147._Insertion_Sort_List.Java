/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode p=head;
        ListNode temp=p;
        ListNode res=null;
        while(p!=null){
            temp=p.next;
            p.next=null;
            res=insert(res,p);
            p=temp;
        }
        return res;
    }
    private ListNode insert(ListNode head, ListNode v){
        if(head==null || v.val<=head.val){
            v.next=head;return v;
        }
        ListNode p=head;
        while(p!=null){
            if(v.val<=p.val){
                int temp=p.val;
                p.val=v.val;
                v.val=temp;
                v.next=p.next;
                p.next=v;
                return head;
            }
            if(p.next==null){
                p.next=v;
                return head;
            }
            p=p.next;
        }
        return head;
        
    }
}
