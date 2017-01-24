public class Solution {
private char[] OPTS={'+','-','*','/'};
private int oneStepOpt(int a,int b,char opt){
    switch(opt){
    case '+':
        return a+b;
    case '-':
        return a-b;
    case '*':
        return a*b;
    case '/':
        return a/b;
    }
    return 0;
}
public int calculate(String s) {
    LinkedList<Integer> nums=new LinkedList<Integer>();
    LinkedList<Character> opts=new LinkedList<Character>();
    long res=0;
    String tmp="";
    char ch;
    for(int i=0;i<s.length();i++){
        ch=s.charAt(i);
        if(ch>='0' && ch<='9'){
            tmp=tmp+ch;
            if(i!=s.length()-1)
            continue;
        }
        if(tmp.length()>0 &&(ch>'9' || ch<'0'|| i==s.length()-1)){
            //store number
            int t=Integer.parseInt(tmp);
            nums.add(t);
            tmp="";
            if(!opts.isEmpty() && (opts.getLast()=='*'||opts.getLast()=='/' )){
                int b=nums.pollLast();int a=nums.pollLast();
                nums.add(oneStepOpt(a,b,opts.pollLast()));
            }
        }
        for(int j=0;j<OPTS.length;j++){
            if(ch==OPTS[j]){
                //get an opts
                opts.add(OPTS[j]);
                break;
            }
        }
    }
    //finish the add and minus part left to right
    while(!opts.isEmpty()){
        int a=nums.poll();int b=nums.poll();
        nums.addFirst(oneStepOpt(a,b,opts.poll()));
    }
    if(nums.isEmpty())return 0;
    return nums.peek();
}
}
