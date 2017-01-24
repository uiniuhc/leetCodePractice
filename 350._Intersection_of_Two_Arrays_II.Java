public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i:nums1){
            if(map.containsKey(i))map.put(i,map.get(i)+1);
            else map.put(i,1);
        }
        for(int i:nums2){
            if(map.containsKey(i)){
                res.add(i);
                int left=map.get(i)-1;
                if(left==0){
                    map.remove(i);
                }else{
                    map.put(i,left);
                }
            }
        }
        int[] ret = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ret[i]=res.get(i);
        }
        return ret;
    }
}
