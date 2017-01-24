public class Solution {
    private String getRange(int l,int r){
        if(l==r) return ""+l;
        return ""+l+"->"+r;
    }
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res=new ArrayList<String>();
        if(nums.length==0)return res;
        int last=nums[0];
        int left=last;
        int right=last;
        for(int i:nums){
            if(i==last)continue;
            if(i==last+1)right=i;
            if(i>last+1){
                //record the old one
                res.add(getRange(left,right));
                //start the new interval
                left=i;right=i;last=i;
            }
            last=i;
        }
        res.add(getRange(left,right));
        return res;
    }
}
