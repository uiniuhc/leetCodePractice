/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        Map<RandomListNode,RandomListNode> old2new = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode res=normalCopy(head,old2new);
        RandomListNode p=head;
        RandomListNode pres=res;
        while(p!=null){
            if(p.random!=null){
                pres.random=old2new.get(p.random);
            }
            p=p.next;
            pres=pres.next;
        }
        return res;
        
    }
    private RandomListNode normalCopy(RandomListNode head,Map<RandomListNode,RandomListNode> o2n){
        RandomListNode s=new RandomListNode(head.label);
        o2n.put(head,s);
        if(head.next!=null){
            s.next=normalCopy(head.next, o2n);
        }
        return s;
    }
    
}
