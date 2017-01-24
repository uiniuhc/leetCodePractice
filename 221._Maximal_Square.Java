public class Solution {
    public int maximalSquare(char[][] matrix) {
            if(matrix.length==0)return 0;
            if(matrix[0].length==0)return 0;
            int[][] mleft=new int[matrix.length][matrix[0].length];
            int[][] mup=new int[matrix.length][matrix[0].length];
            int[][] mres=new int[matrix.length][matrix[0].length];
            int max=0;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][0]=='1') {mleft[i][0]=1;mres[i][0]=1;max=1;}
            }
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[0][i]=='1') {mup[0][i]=1;mres[0][i]=1;max=1;}
            }
            
            
            
            for(int i=1;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    if(matrix[i][j]=='0'){
                        mleft[i][j]=mup[i][j]=mres[i][j]=0;
                    }else{
                        mleft[i][j]=(char) (mleft[i][j-1]+1);
                        mup[i][j]=(char) (mup[i-1][j]+1);
                        mres[i][j]=(char) Math.min(mleft[i][j], Math.min(mup[i][j], mres[i-1][j-1]+1));
                        if(mres[i][j]>max){
                            max=mres[i][j];
                        }
                    }
                }
            }
            return max*max;
    
    }
}
