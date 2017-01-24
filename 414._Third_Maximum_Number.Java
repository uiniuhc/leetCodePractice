public class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length==0)return 0;
        TreeSet<Integer> set=new TreeSet<Integer>();
        for(int i:nums){
            if(set.contains(i))continue;
            if(set.size()==3 && i>set.first()){set.pollFirst();set.add(i);}
            if(set.size()<3){
                set.add(i);
            }
        }
        if(set.size()<3)return set.pollLast();
        return set.pollFirst();
        
    }

}
