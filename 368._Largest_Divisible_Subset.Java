public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length<1)return new ArrayList<Integer>();
        Arrays.sort(nums);
        //reverse order
        int l=0;int r=nums.length-1;
        while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;r--;
        }
        int[] pre=new int[nums.length];
        int[] opt=new int[nums.length];
        opt[0]=1;
        int best=1;
        pre[0]=-1;
        int from=0;
        for(int i=1;i<nums.length;i++){
            int max=1;
            opt[i]=1;
            pre[i]=-1;
            for(int j=0;j<i;j++){
                if(nums[j]%nums[i]==0){
                    int t=opt[j]+1;
                    if(t>max){
                        opt[i]=t;
                        pre[i]=j;
                        max=t;
                    }
                }
            }
            if(max>best){
                best=max;from=i;
            }
        }
        //trace back the max
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(from!=-1){
            res.add(nums[from]);
            from=pre[from];
        }
        return res;
        
    }
}
