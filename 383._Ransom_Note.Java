public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length())return false;
        if(ransomNote.length()==0)return true;
        HashMap<Character,Integer> charNum=new HashMap<Character,Integer>();
        char[] mag=magazine.toCharArray();
        char[] ran=ransomNote.toCharArray();
        for(char ch:ran){
            if(charNum.containsKey(ch)){
                charNum.put(ch,charNum.get(ch)+1);
            }else{
                charNum.put(ch,1);
            }
        }
        int count=0;
        for(char ch:mag){
            if(charNum.containsKey(ch)){
                count++;
                charNum.put(ch,charNum.get(ch)-1);
                if(charNum.get(ch)==0) {
                    charNum.remove(ch);
                }
                if(count==ransomNote.length())return true;
            }
            
        }
        return false;
    }
}
