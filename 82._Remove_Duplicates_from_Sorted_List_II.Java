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
        if(head==null||head.next==null)return head;
        ListNode newList=null;
        ListNode pnew=null;
        ListNode p=head;
        int curr=head.val;
        int count=0;
        while(true){
            if((p!=null && p.val!=curr) || p==null){
                //update values
                if(count==1){
                    if(pnew==null){
                        pnew=new ListNode(curr);
                        newList=pnew;
                    }
                    else{
                        pnew.next=new ListNode(curr);
                        pnew=pnew.next;
                    }
                }
                if(p!=null) curr=p.val;
                count=1;
            }else if(p!=null && p.val==curr){
                count++;
            }
            if(p==null)break;
            p=p.next;
        }
        return newList;
    }

}
