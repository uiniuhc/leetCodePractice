public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] charNum=new int[26];
        for(char ch:s.toCharArray()){
            charNum[(int)(ch-'a')]++;
        }
        for(char ch:t.toCharArray()){
            charNum[(int)(ch-'a')]--;
        }
        for(int i:charNum){
            if(i!=0)return false;
        }
        return true;
    }
}
