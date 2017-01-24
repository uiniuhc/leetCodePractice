/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode reverseLinkedList(ListNode head){
        ListNode p=head;
        if(p==null || p.next==null)return head;
        p=p.next;
        head.next=null;
        ListNode tmp;
        while(p!=null){
            //now p is head
            tmp=p.next;
            p.next=head;
            head=p;
            p=tmp;
        }
        return head;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode p=head;
        int count=0;
        while(p!=null){
            p=p.next;
            count++;
        }
        p=head;
        int index=0;
        //read until half
        while(index<count/2){
            p=p.next;
            index++;
        }
        if(count%2==1)p=p.next;
        p=reverseLinkedList(p);
        //start compare
        while(p!=null && head!=null){
            if(p.val!=head.val)return false;
            p=p.next;
            head=head.next;
        }
        return true;
        
        
    }
}
