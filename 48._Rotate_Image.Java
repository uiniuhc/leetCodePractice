public class Solution {
    private void rotateOuterCycle(int[][] matrix, int l,int r){
        if(l>=r )return;
        for(int i=0;i<r-l;i++){
            int temp=matrix[l][l+i];
            matrix[l][l+i]=matrix[r-i][l];
            matrix[r-i][l]=matrix[r][r-i];
            matrix[r][r-i]=matrix[l+i][r];
            matrix[l+i][r]=temp;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int low=0;
        int high=n-1;
        while(n>0){
            rotateOuterCycle(matrix,low++,high--);
            n--;
        }
    }
}
