public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length()==0)return false;
        String[] list=str.split(" ");
        if(pattern.length()!=list.length)return false;
        HashMap<String,Character> map=new HashMap<String,Character>();
        boolean [] used=new boolean[26];
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(list[i])){
                //check it is the same
                char ch=map.get(list[i]);
                if(ch!=pattern.charAt(i))return false;
            }else{
                if(used[(int)(pattern.charAt(i)-'a')])
                    return false;
                map.put(list[i],pattern.charAt(i));
                used[(int)(pattern.charAt(i)-'a')]=true;
            }
        }
        return true;
    }
}
