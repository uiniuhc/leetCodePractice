public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0){
           return s.length()==0;
        }
        if(p.length()>1 && p.charAt(1)=='*'){
            if(isMatch(s, p.substring(2)))return true;
        }
        if(s.length()==0)return false;
        //from left to match a char, and then match for the rest
        char ch=s.charAt(0);
        boolean res=false;
        if(p.charAt(0)==ch ||p.charAt(0)=='.'){
            //use it
            if(isMatch(s.substring(1), p.substring(1)))return true;
            if(p.length()>1 && p.charAt(1)=='*'){
                if(isMatch(s.substring(1),p))return true;
            }
        }
        
        //if nothing can match, return false
        return false;
    }
}
