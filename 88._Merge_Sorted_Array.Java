public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //init
        for(int i=m-1;i>=0;i--){
            nums1[i+n]=nums1[i];
        }
        //merge start
        int p1=n;
        int p2=0;
        int pcurr=0;
        while(p1<m+n && p2<n){
            if(nums1[p1]<nums2[p2]){
                //push p1
                nums1[pcurr++]=nums1[p1++];
            }else{
                //push p2
                nums1[pcurr++]=nums2[p2++];
            }
        }
        while(p1<m+n){
            nums1[pcurr++]=nums1[p1++];
        }
        while(p2<n){
            nums1[pcurr++]=nums2[p2++];
        }
    }
}
