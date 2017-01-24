public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;
        ArrayList<Integer> countList=new ArrayList<Integer>();
        countList.add(nums[0]);
        for(int i:nums){
            if(i>countList.get(countList.size()-1)){
                countList.add(i);
                if(countList.size()>=3)return true;
            }
            else{
                //find the position for i
                for(int j=0;j<countList.size();j++){
                    if(i==countList.get(j))break;
                    if(i<countList.get(j)){
                        countList.set(j,i);
                        break;
                    }
                }
            }
        }
        return false;
    }
}
