/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        //get the size of the linked list
        ListNode p=head;
        int count=0;
        while(p!=null){
            count++;p=p.next;
        }
        return sortListHelper(head,count);
    }
    private ListNode sortListHelper(ListNode head,int n){
        if(n==1 ||n==0)return head;
        ListNode p=head;
        //find the half place
        int mid=n/2;
        for(int i=0;i<mid-1;i++){
            p=p.next;
        }
        //sort
        ListNode lr=sortListHelper(p.next,n-n/2);
        p.next=null;
        ListNode ll=sortListHelper(head,n/2);
        //merge
        ListNode res;
        if(lr.val<ll.val){
                //put lr
            res=lr;lr=lr.next;
        }else{
                //put ll
            res=ll;ll=ll.next;
        }
        p=res;
        while(lr!=null && ll!=null){
            if(lr.val<ll.val){
                //put lr
                p.next=lr;p=lr;lr=lr.next;
            }else{
                //put ll
                p.next=ll;p=ll;ll=ll.next;
            }
        }
        p.next=null;
        if(lr!=null){
            p.next=lr;
        }
        if(ll!=null){
            p.next=ll;
        }
        return res;
    }
    
}
