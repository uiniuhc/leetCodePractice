public class Solution {
    public int longestPalindrome(String s) {
        int[] lNums=new int[26];
        int[] uNums=new int[26];
        for(char ch:s.toCharArray()){
            if(Character.isLowerCase(ch)){
                lNums[(int)(ch-'a')]++;            
            }else if(Character.isUpperCase(ch)){
                uNums[(int)(ch-'A')]++;
            }
        }
        int odd=0;
        int even=0;
        for(int i:lNums){
            even+=(i-(i&1));
            odd+=i&1;
        }
        for(int i:uNums){
            even+=(i-(i&1));
            odd+=i&1;
        }
        return odd>0?even+1:even;
    }
}
