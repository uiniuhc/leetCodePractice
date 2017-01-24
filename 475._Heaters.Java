public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        //find max and min
        int min=houses[0]<heaters[0]?houses[0]:heaters[0];
        int max=houses[houses.length-1]>heaters[heaters.length-1]?
            houses[houses.length-1] : heaters[heaters.length-1];
        int r=max-min;
        int l=0;
        int lastOk=-1;
        //binary search
        while(l<=r){
            int radius=(l+r)/2;
            //check radius
            if(checkRadius(houses,heaters,radius)){
                //ok then shrink it
                r=radius-1;
                lastOk=radius;
            }else{
                //not ok then broden it
                l=radius+1;
            }
        }
        return lastOk;
    }
    //sorted houses and heaters
    private boolean checkRadius(int[] houses,int [] heaters,int radius){
        int needL=0;
        for(int h:heaters){
            if(h-radius>houses[needL])return false;
            needL=findFirstAfter(houses,h+radius);
            if(needL==Integer.MAX_VALUE)break;
        }
        if(heaters[heaters.length-1]+radius<houses[houses.length-1])return false;
        return true;
    }
    //find first number after t in the sorted array nums
    //return index
    private int findFirstAfter(int[] nums,int t){
        if(t>=nums[nums.length-1])return Integer.MAX_VALUE;
        int l=0;int r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(t>=nums[mid] ){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return (l+r)/2;
    }
    
}
