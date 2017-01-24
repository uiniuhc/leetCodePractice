public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(char ch:s.toCharArray()){
            if(isOpen(ch))stack.push(ch);
            else if(isClose(ch)){
                if(stack.size()==0)return false;
                char last=getClose(stack.pop());
                if(last!=ch){
                    return false;
                }
            }
        }
        
        return stack.size()==0;
    }

    private boolean isOpen(char ch){
        return ch=='(' || ch=='[' || ch=='{';
    }
    private boolean isClose(char ch){
        return ch==']' || ch=='}'|| ch==')';
    }
    private char getClose(char ch){
        switch(ch){
            case '(':return ')';
            case '[':return ']';
            case '{':return '}';
        }
        return ' ';
    }
}
