public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0)return false;
        int num_col=matrix[0].length;
        int num_row=matrix.length;
        int x=0;
        int y=num_col-1;
        while(x<num_row && y>=0){
            if(matrix[x][y]>target){
                y--;
            }else if(matrix[x][y]<target){
                x++;
            }else{
                return true;
            }
        }
        return false;
        
    }
}
