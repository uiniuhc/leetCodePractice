public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0 ||k==0)return 0;
        if(k>nums.length)return 0;
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<k;i++)pq.add(nums[i]);
        int min=pq.peek();
        for(int i=k;i<nums.length;i++){
            if(nums[i]>pq.peek()){pq.poll();pq.add(nums[i]);min=pq.peek();}
        }
        return min;
    }
}
