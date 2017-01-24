import java.util.Stack;
public class Solution {
    public String reverseWords(String s) {

        String[] ss=s.split(" ");
        Stack<String> stack=new Stack<String>();
        for(String str:s.split(" ")){
            if(str.length()>0){
                stack.push(str);
            }
        }
        String res="";
        while(!stack.empty()){
            res=res+" "+stack.pop();
        }
        return res.trim();
    }
}
