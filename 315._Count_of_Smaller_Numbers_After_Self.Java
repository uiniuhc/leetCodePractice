public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length==0)return new ArrayList<Integer>();
        if(nums.length==1){ArrayList<Integer> res=new ArrayList<Integer>();res.add(nums[0]);}
        int [][] temp=new int[nums.length][3];
        int [][] numsNum=new int[nums.length][3];
        for(int i=0;i<nums.length;i++){
            numsNum[i][0]=nums[i];
            numsNum[i][1]=i;//position 
            //2 is for the count
        }
        //merge sort and get the count~!
        mergeHelper(numsNum,temp,0,nums.length-1);
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)res.add(0);
        for(int[] a:numsNum){
            res.set(a[1],a[2]);
        }
        return res;
    }
    private void mergeHelper(int[][] nums,int[][] temp, int l,int r){
        if(l>=r){
            return ;
        }
        int mid=(l+r)/2;
        mergeHelper(nums,temp,l,mid);
        mergeHelper(nums,temp,mid+1,r);
        //combine l to mid and mid+1 to r
        int ll=l;
        int lr=mid+1;
        int index=l;
        int wait=0;
        //merge sort
        while(ll<=mid && lr<=r){
        if(nums[ll][0]<=nums[lr][0]){
            nums[ll][2]=nums[ll][2]+wait;
            temp[index][0]=nums[ll][0];temp[index][1]=nums[ll][1];temp[index][2]=nums[ll][2];
            index++;ll++;
        }
        else if(nums[ll][0]>nums[lr][0]){
            temp[index][0]=nums[lr][0];temp[index][1]=nums[lr][1];temp[index][2]=nums[lr][2];
            wait++;
            index++;lr++;
        }
        }
        while(ll<=mid){
            nums[ll][2]=nums[ll][2]+wait;
            temp[index][0]=nums[ll][0];temp[index][1]=nums[ll][1];temp[index][2]=nums[ll][2];
            index++;ll++;
        }
        while(lr<=r){
            temp[index][0]=nums[lr][0];temp[index][1]=nums[lr][1];temp[index][2]=nums[lr][2];
            index++;lr++;
        }
        for(int i=l;i<=r;i++){
            nums[i][0]=temp[i][0];nums[i][1]=temp[i][1];nums[i][2]=temp[i][2];
        }
        
    }
}
