public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res=new ArrayList<int[]>();
        if(k==0 ||nums1.length==0||nums2.length==0)return res;
        PriorityQueue<int[]> heap=new PriorityQueue<int[]>(k,new Comparator<int[]>(){public int compare(int[]a,int[]b){return 
            a[0]+a[1]-b[0]-b[1];}});
        for(int i=0;i<k && i<nums1.length;i++){
            int[] ta={nums1[i],nums2[0],0};
            heap.add(ta);
        }
        
        while(res.size()<k && !heap.isEmpty()){
            int[] tmp=heap.poll();
            if(tmp[2]+1<nums2.length){
                int[] tmp1={tmp[0],nums2[tmp[2]+1],tmp[2]+1};
                heap.add(tmp1);
            }
            int[] tres={tmp[0],tmp[1]};
            res.add(tres);
        }
        return res;
        
    }
}
