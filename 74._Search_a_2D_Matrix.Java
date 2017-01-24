public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)return false;
        int row=findRow(matrix,target);
        if(row<0)return false;
        return findNum(matrix[row],target);
    }
    //lower bound find row
    private int findRow(int[][] matrix,int target){
        int l=0;int r=matrix.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(matrix[mid][0]>target)r=mid-1;
            else if(matrix[mid][0]<target){
                if(mid+1<matrix.length && target<matrix[mid+1][0]) return mid;
                else l=mid+1;
            }
            else return mid;
        }
        if(l>r)return -1;
        return (l+r)/2;
    }
    //find it
    private boolean findNum(int[] nums,int target){
        int l=0;int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)return true;
            else if(nums[mid]<target)l=mid+1;
            else r=mid-1;
        }
        return false;
    }
    
}
