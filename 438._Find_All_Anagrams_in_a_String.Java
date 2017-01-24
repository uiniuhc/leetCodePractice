public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<Integer>();
        if(s.length()<p.length())return res;
        int[] count_p=new int[26];
        int[] curr_count=new int[26];
        //statics of p
        for(int i=0;i<p.length();i++){
            count_p[p.charAt(i)-'a']++;
        }
        //see what we got now
        for(int i=0;i<s.length();i++){
            //get rid of old one
            int label=0;
            if(i>=p.length()){
                label=s.charAt(i-p.length())-'a';
                curr_count[label]--;
            }
            label=s.charAt(i)-'a';
            curr_count[label]++;
            
            if(Arrays.equals(curr_count,count_p)) res.add(i-p.length()+1);
        }
        return res;
    }
}
