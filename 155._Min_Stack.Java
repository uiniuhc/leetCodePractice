public class MinStack {
    LinkedList<int[]> list;
    int currMin;
    /** initialize your data structure here. */
    public MinStack() {
        list=new LinkedList<int[]>();
        currMin=Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<currMin){
            currMin=x;
        }
        int [] val=new int[2];
        val[0]=x;
        val[1]=currMin;
        list.addFirst(val);
    }
    
    public void pop() {
        if(list.size()>0){
            list.removeFirst();
            if(list.size()>0)currMin=list.getFirst()[1];
            else currMin=Integer.MAX_VALUE;
        }
        
    }
    
    public int top() {
        return list.getFirst()[0];
    }
    
    public int getMin() {
        if(list.size()==0)return 0;
        return currMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
