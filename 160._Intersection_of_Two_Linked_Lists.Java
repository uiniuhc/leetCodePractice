/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1=countLen(headA);
        int len2=countLen(headB);
        int diff=len1-len2;
        ListNode pShort=headB;
        ListNode pLong=headA;
        if(len1<len2){
            pLong=headB;pShort=headA;diff=-diff;
        }
        while(diff>0){
            pLong=pLong.next;diff--;
        }
        while(pShort!=null && pLong!=null){
            if(pShort==pLong)return pShort;pShort=pShort.next;pLong=pLong.next;
        }
        return null;
        
    }
    private int countLen(ListNode head){
        ListNode p=head;
        int count=0;
        while(p!=null){
            count++;p=p.next;
        }
        return count;
    }
}
