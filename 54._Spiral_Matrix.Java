public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(matrix.length==0) return res;
        boolean [][] used=new boolean[matrix.length][matrix[0].length];
        dfs(matrix,res,used,0,0,0);
        return res;
    }
    private void dfs(int [][] matrix,ArrayList<Integer> res,boolean[][] used,int x,int y,int dir){
        if(x<0 || x>=matrix.length)return ;
        if(y<0 || y>=matrix[x].length)return ;
        if(used[x][y])return ;
        used[x][y]=true;
        res.add(matrix[x][y]);
        switch(dir){
        case 0:
            dfs(matrix,res,used,x,y+1,0);break;
        case 1:
            dfs(matrix,res,used,x+1,y,1);break;
        case 2:
            dfs(matrix,res,used,x,y-1,2);break;
        case 3:
            dfs(matrix,res,used,x-1,y,3);break;
        }
        //right
        dfs(matrix,res,used,x,y+1,0);
        //down
        dfs(matrix,res,used,x+1,y,1);
        //left
        dfs(matrix,res,used,x,y-1,2);
        //up
        dfs(matrix,res,used,x-1,y,3);
       
    }
}
