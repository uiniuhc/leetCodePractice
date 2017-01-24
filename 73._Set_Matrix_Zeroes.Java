public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)return;
        boolean up=false;
        boolean down=false;
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0)up=true;
            if(matrix[i][n-1]==0)down=true;
        }
        boolean left=false;
        boolean right=false;
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0)left=true;
            if(matrix[m-1][i]==0)right=true;
        }
        //start label
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        //start set zero
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0)for(int j=1;j<n;j++)matrix[i][j]=0;
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0)for(int i=1;i<m;i++)matrix[i][j]=0;
        }
        //set margin zero
        if(up)for(int i=0;i<m;i++)matrix[i][0]=0;
        if(down)for(int i=0;i<m;i++)matrix[i][n-1]=0;
        if(left)for(int i=0;i<n;i++)matrix[0][i]=0;
        if(right)for(int i=0;i<n;i++)matrix[m-1][i]=0;
        
    }
}
