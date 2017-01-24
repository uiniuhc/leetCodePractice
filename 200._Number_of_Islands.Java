public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0){
            return 0;
        }
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]=='1'){
                   res++;
                   filling(grid,i,j,'1','0');
               } 
            }
        }
        return res;
    }
    //fill all connected old value to new value
    private void filling(char[][]grid,int x,int y, char oldval,char newval){
        Queue<Integer> qx=new LinkedList<Integer>();
        Queue<Integer> qy=new LinkedList<Integer>();
        qx.add(x);qy.add(y);grid[x][y]=newval;
        while(!qx.isEmpty()){
            int tx=qx.poll();
            int ty=qy.poll();
           if(checkValid(grid,tx+1,ty) && grid[tx+1][ty]==oldval){
                grid[tx+1][ty]=newval;
                qx.add(tx+1);qy.add(ty);    
            }
            if(checkValid(grid,tx-1,ty) && grid[tx-1][ty]==oldval){
                grid[tx-1][ty]=newval;
                qx.add(tx-1);qy.add(ty);    
            }
            if(checkValid(grid,tx,ty-1) && grid[tx][ty-1]==oldval){
                grid[tx][ty-1]=newval;
                qx.add(tx);qy.add(ty-1);    
            }
            if(checkValid(grid,tx,ty+1) && grid[tx][ty+1]==oldval){
                grid[tx][ty+1]=newval;
                qx.add(tx);qy.add(ty+1);    
            }
            grid[tx][ty]=newval;
        }
    }
    private boolean checkValid(char[][] grid,int x,int y){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length;
    }
}
