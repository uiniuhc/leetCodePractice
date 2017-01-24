/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class IntFrom implements Comparable<IntFrom>{
        public int val;
        public int from;
        public IntFrom(int v,int f){val=v;from=f;}
        
        public int compareTo(IntFrom o) {
            // TODO Auto-generated method stub
            
            return val-o.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=null;
        ListNode last=null;
        PriorityQueue<IntFrom> heap=new PriorityQueue<IntFrom>();
        //init
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                IntFrom curr=new IntFrom(lists[i].val,i);
                heap.add(curr);
            }
        }
        //extract
        while(heap.peek()!=null){
            IntFrom curr=heap.poll();
            ListNode ln=new ListNode(curr.val);
            if(res==null){
                res=ln;
                last=ln;
            }else{
                last.next=ln;
                last=last.next;
            }
            //add next one
            lists[curr.from]=lists[curr.from].next;
            if(lists[curr.from]!=null){
                IntFrom temp=new IntFrom(lists[curr.from].val,curr.from);
                heap.add(temp);
            }
            
        }
        return res;
    }
}
