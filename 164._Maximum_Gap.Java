public class Solution {
      public int maximumGap(int[] nums) {
        if(nums.length<2)return 0;
        //find min and max
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        int[][] bucket_detail=new int[nums.length][2];//store min and max for each buckets
        for(int[] min_max:bucket_detail){
            min_max[0]=-1;
            min_max[1]=-1;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min)min=nums[i];
            if(nums[i]>max)max=nums[i];
            bucket_detail[i][0]=-1;
            bucket_detail[i][1]=-1;
        }
        int t=1;//bucket size
        if(max-min>nums.length){
            t=(max-min)/nums.length;//bucket size
        }
        int max_gap=0;
        //check the difference inside the bucket
        for(int i:nums){
            int buc=(i-min)/t;
            if(buc>=nums.length)buc=nums.length-1;
            if(bucket_detail[buc][0]==-1 || bucket_detail[buc][0]>i){
                bucket_detail[buc][0]=i;
            }
            if(bucket_detail[buc][1]==-1 || bucket_detail[buc][1]<i){
                bucket_detail[buc][1]=i;
            }
        }
        int last_max=bucket_detail[0][1];
        //use this max to compare with the next min
        for(int i=1;i<nums.length;i++){
            //count the max gap inside the bucket
            if(bucket_detail[i][0]==-1)continue;
            if(bucket_detail[i][0]-last_max>max_gap)max_gap=bucket_detail[i][0]-last_max;
            last_max=bucket_detail[i][1];
        }
        return max_gap;
    }
}
