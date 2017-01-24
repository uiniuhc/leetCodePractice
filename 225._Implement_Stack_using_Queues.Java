class MyStack {
    Queue<Integer> que;
    Queue<Integer> temp;
    int qtop;
    public MyStack(){
        que=new LinkedList<Integer>();
        temp=new LinkedList<Integer>();
    }
    // Push element x onto stack.
    public void push(int x) {
        que.add(x);
        qtop=x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        int count=0;
        while(!que.isEmpty()){
            temp.add(que.poll());count++;
        }
        while(count>1){
            qtop=temp.poll();
            que.add(qtop);
            count--;
        }
        while(!temp.isEmpty())temp.poll();
    }

    // Get the top element.
    public int top() {
        return qtop;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return que.isEmpty();
    }
}
