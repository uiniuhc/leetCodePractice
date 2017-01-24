/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head ==null || head.next==null)return head;
        //count for k elements
        ListNode p=head;
        int count=0;
        while(p!=null){
            count++;
            if(count==k) break;
            p=p.next;
        }
        if(count<k){return head;}
        //run reverseKGroup for the 2nd part
        ListNode p2=null;
        p2=reverseKGroup(p.next,k);
        //reverse the first part
        p.next=null;
        ListNode p1=reverseList(head);
        return listCat(p1,p2);
        //cat first and second part
    }
    //reverse a list and return the first one
    private ListNode reverseList(ListNode head){
        if(head==null || head.next==null)return head;
        ListNode p=head.next;
        head.next=null;
        ListNode tmp;
        while(p!=null){
            tmp=p.next;
            p.next=head;
            head=p;
            p=tmp;
        }
        return head;
    }
    private ListNode listCat(ListNode a,ListNode b){
        if(a==null)return b;
        ListNode p=a;
        while(p.next!=null)p=p.next;
        p.next=b;
        return a;
    }
}
