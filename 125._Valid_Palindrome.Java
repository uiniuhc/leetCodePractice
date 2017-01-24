public class Solution {
    private boolean isAlphaNum(char ch){
        return (ch>='a' && ch<='z')||(ch>='0' && ch<='9');
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s=s.toLowerCase();
        while(i<j){
            while(i<j && !isAlphaNum(s.charAt(i)))i++;
            while(i<j && !isAlphaNum(s.charAt(j)))j--;
            if(s.charAt(i)!=s.charAt(j)) return false;
            else{i++;j--;}
        }
        return true;
    }
}
