public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<List<String>>();
        HashMap<Integer,List<String>> map=new HashMap<Integer,List<String>>();
        int maxLen=0;
        for(String str:strs){
            if(str.length()>maxLen)maxLen=str.length();
        }
        for(String str:strs){
            long key=1;
            
            for(int i=0;i<str.length();i++){
                int n=str.charAt(i)-'a';
                key=(key*(n*n+n+41))%Integer.MAX_VALUE;
            }
            int tkey=(int)key;
            if(map.containsKey(tkey)){
                map.get(tkey).add(str);
            }
            else{
                List<String> list=new ArrayList<String>();
                list.add(str);
                map.put(tkey,list);
                res.add(list);
            }
            
            
        }
        return res;
    }
}
