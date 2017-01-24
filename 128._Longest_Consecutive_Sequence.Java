public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> record=new HashSet<Integer>();
        for(int ii:nums){
            record.add(ii);
        }
        int max=0;
        for(int ii:nums){
            int res=0;
            int test=ii;
            while(record.contains(test)){
                res++;
                record.remove(test);
                test--;
            }
            test=ii+1;
            while(record.contains(test)){
                res++;
                record.remove(test);
                test++;
            }
            if(res>max){
                max=res;
            }
        }
        return max;
    }
}
