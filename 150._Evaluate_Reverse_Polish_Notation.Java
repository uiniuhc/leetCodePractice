public class Solution {
    public int evalRPN(String[] tokens) {
        int res=0;
        if(tokens.length==0)return 0;
        Stack<Integer> numSeq=new Stack<Integer>();
        for(String str:tokens){
            if(str==null || str.length()==0 )continue;
            
            if(str.matches("^-?\\d+$")){
                numSeq.push(Integer.parseInt(str));
            }else if(numSeq.size()>=2){
                int b=numSeq.pop();
                int a=numSeq.pop();
                int c=0;
                switch(str.charAt(0)){
                    case '+':
                        c=a+b;
                        break;
                    case '-':
                        c=a-b;
                        break;
                    case '*':
                        c=a*b;
                        break;
                    case '/':
                        c=a/b;
                        break;
                }
                numSeq.push(c);
            }
        }
        return numSeq.peek();
    }
}
