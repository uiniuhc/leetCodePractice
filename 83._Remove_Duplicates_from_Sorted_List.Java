/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        
        ListNode p=head;
        ListNode pn=p.next;
        int last=p.val;
        while(pn!=null){
            if(last==pn.val){
                //delete it
                p.next=pn.next;
                pn=p.next;
            }
            else{
                last=pn.val;
                p=p.next;
                pn=pn.next;
            }
        }
        return head;
    }
}
