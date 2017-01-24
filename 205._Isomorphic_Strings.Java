public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        if(s.length()<2)return true;
        HashMap<Character, Character> map=new HashMap<Character,Character>();
        HashSet<Character> mapped=new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(map.containsKey(ch1) && map.get(ch1)==ch2){continue;}
            else if(map.containsKey(ch1) && map.get(ch1)!=ch2){
                return false;
            }
            else if(!map.containsKey(ch1) && mapped.contains(ch2)){
                return false;
            }else{
                map.put(ch1,ch2);mapped.add(ch2);
            }
        }
        return true;
    }
}
