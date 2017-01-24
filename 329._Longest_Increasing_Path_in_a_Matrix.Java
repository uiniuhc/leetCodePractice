public class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)return 0;
        int[][] pathLen=new int[matrix.length][matrix[0].length];
        int res=1;
        //init, find local minimum! 
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                boolean isMin=true;
                if(i-1>=0 && matrix[i][j]>matrix[i-1][j])isMin=false;
                if(i+1<matrix.length && matrix[i][j]>matrix[i+1][j])isMin=false;
                if(j-1>=0 && matrix[i][j]>matrix[i][j-1])isMin=false;
                if(j+1<matrix[0].length && matrix[i][j]>matrix[i][j+1])isMin=false;
                if(isMin) pathLen[i][j]=1;
                else pathLen[i][j]=0;
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int t=getPathLen(matrix,pathLen, i, j);if(t>res)res=t;
            }
        }
        return res;
    }
    private int getPathLen(int[][]matrix,int[][]pLen,int i,int j){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length)return 0;
        if(pLen[i][j]>0)return pLen[i][j];
        int max=0;
        int temp=0;
        if(i-1>=0 && matrix[i][j]>matrix[i-1][j]){
            temp=1+getPathLen(matrix,pLen, i-1, j); if(temp>max)max=temp;
        }
        if(i+1<matrix.length && matrix[i][j]>matrix[i+1][j]){
            temp=1+getPathLen(matrix,pLen, i+1, j); if(temp>max)max=temp;
        }
        if(j-1>=0 && matrix[i][j]>matrix[i][j-1]){
            temp=1+getPathLen(matrix,pLen, i, j-1); if(temp>max)max=temp;
        }
        if(j+1<matrix[0].length && matrix[i][j]>matrix[i][j+1]){
            temp=1+getPathLen(matrix,pLen, i, j+1); if(temp>max)max=temp;    
        }
        pLen[i][j]=max;
        return max;
    }
}
