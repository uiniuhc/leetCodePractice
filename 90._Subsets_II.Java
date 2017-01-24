public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());//add a empty set
        if(nums.length==0)return res;
        //make nums to unique and get the repitition times
        Arrays.sort(nums);
        int last=0;
        int count=1;
        ArrayList<Integer> uniqueOnes=new ArrayList<Integer>();
        HashMap<Integer,Integer> freq=new HashMap<Integer,Integer>();
        uniqueOnes.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[last]){
                uniqueOnes.add(nums[i]);
                freq.put(nums[last],count);
                count=1;
                last=i;
            }else{
                count++;
            }
        }
        freq.put(nums[last],count);
///////////////////////////////////////////now do the same as subsets with no duplicate
///but add repeat times of same number if it contains that number
        subsetsHelper(uniqueOnes,new ArrayList<Integer>(),res,0,freq);
        return res;
        
    }
    public void subsetsHelper(List<Integer> nums,List<Integer> curr,List<List<Integer>> res, int start,HashMap<Integer,Integer
        > freq){
        if(start==nums.size()){
            return ;
        }
        List<Integer> used=curr;
        //choose one number from start
        for(int i=start;i<nums.size();i++){
            used=curr;
            for(int j=0;j<freq.get(nums.get(i));j++){
                ArrayList<Integer> using=new ArrayList<Integer>(used);
                using.add(nums.get(i));
                res.add(using);
                used=using;
                subsetsHelper(nums,using,res, i+1,freq);
            }
        }
    }
}
