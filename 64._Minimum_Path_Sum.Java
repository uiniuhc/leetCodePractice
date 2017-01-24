public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0)return 0;
        int[] tempSum=new int[grid.length];
        //init
        tempSum[0]=grid[0][0];
        for(int i=1;i<tempSum.length;i++){
            tempSum[i]=grid[i][0]+tempSum[i-1];
        }
        for(int j=1;j<grid[0].length;j++){
            tempSum[0]+=grid[0][j];
            for(int i=1;i<tempSum.length;i++){
                tempSum[i]=grid[i][j]+ (tempSum[i]<tempSum[i-1]?tempSum[i]:tempSum[i-1]);
            }
        }
        return tempSum[tempSum.length-1];
    }
}
