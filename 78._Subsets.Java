public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        if(nums.length==0)return res;
        for(int i=1;i<1<<nums.length;i++){
            ArrayList<Integer> tmp=new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++){
                if((1<<j&i)>0){
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
