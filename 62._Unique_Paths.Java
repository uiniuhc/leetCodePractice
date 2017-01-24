public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pt=new int [m][n];
        
        for(int i=0;i<m;i++){
            pt[i][0]=1;
        }
        for(int i=0;i<n;i++){
            pt[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                pt[i][j]=pt[i-1][j]+pt[i][j-1];
            }
        }
        return pt[m-1][n-1];
    }
}
