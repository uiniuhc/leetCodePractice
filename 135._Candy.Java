public class Solution {
    private int goUpHill(int[] nums,int curr,int[] given){
        if(given[curr]>0) return 0;
        given[curr]=1;
        int sum=1;
        if(curr>0){
            //go left
            int candyLevel=1;
            int last=nums[curr];
            for(int i=curr-1;i>=0;i--){
                if(nums[i]>last){
                    candyLevel++;
                }else if(nums[i]<=last){
                    break;
                }
                last=nums[i];
                if(candyLevel>given[i]){
                    sum+=candyLevel-given[i];
                    given[i]=candyLevel;
                }
            }
        }
        if(curr<nums.length-1){
            //go right
            int candyLevel=1;
            int last=nums[curr];
            for(int i=curr+1;i<nums.length;i++){
                if(nums[i]>last){
                    candyLevel++;
                }else if(nums[i]<=last){
                    break;
                }
                last=nums[i];
                if(candyLevel>given[i]){
                    sum+=candyLevel-given[i];
                    given[i]=candyLevel;
                }
            }
        }
        return sum;
    }
    public int candy(int[] ratings) {
        if(ratings.length==0)return 0;
        int[] given=new int[ratings.length];
        
        if(ratings.length==1)return 1;
        int res=0;
        //find local minimum
        for(int i=0;i<ratings.length;i++){
            if(i==0 && ratings[i]<=ratings[i+1]){
                res+=goUpHill(ratings,i,given);
            }else if(i==ratings.length-1 && ratings[i]<=ratings[i-1]){
                res+=goUpHill(ratings,i,given);
            }else if(i>0 && i< ratings.length-1 && ratings[i]<=ratings[i-1] && ratings[i]<=ratings[i+1]){
                res+=goUpHill(ratings,i,given);
            }
        }
        //give candy in bidirections
        return res;
    }
}
