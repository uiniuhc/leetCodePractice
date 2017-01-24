public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int p1,p2;
        if(s.length()==0)return 0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int len=0;
        int max=0;
        for(p1=0,p2=0;p1<s.length();p1++){
            char ch=s.charAt(p1);
            if(map.containsKey((int)ch)){
                int last=map.get((int)ch);
                if(last>p2)p2=last;
                len=p1-p2;
                map.put((int)ch,p1);
            }else{
                map.put((int)ch,p1);
                len++;
            }
            if(len>max)max=len;
        }
        return max;
    }
}
