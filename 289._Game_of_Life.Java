public class Solution {
    private int checkNeighbor(int[][] board, int x,int y){
        int count=0;
        int len=board.length;
        int wid=board[0].length;
        if(x-1>=0 && board[x-1][y]%10==1)count++;
        if(x+1<len && board[x+1][y]%10==1)count++;
        if(y-1>=0 && board[x][y-1]%10==1)count++;
        if(y+1<wid && board[x][y+1]%10==1)count++;
        if(x-1>=0 && y-1>=0 && board[x-1][y-1]%10==1)count++;
        if(x-1>=0 && y+1<wid && board[x-1][y+1]%10==1)count++;
        if(x+1<len && y+1<wid && board[x+1][y+1]%10==1)count++;
        if(x+1<len && y-1>=0 && board[x+1][y-1]%10==1)count++;
        return count;
    }
    public void gameOfLife(int[][] board) {
        if(board.length==0||board[0].length==0)return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int live=checkNeighbor(board,i,j);
                board[i][j]=live*10+board[i][j]%10;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int live=board[i][j]/10;
                //for living one
                if(board[i][j]%10==1){
                    if(live==2 ||live==3)board[i][j]=1;
                    else board[i][j]=0;
                }else{
                    if(live==3)board[i][j]=1;
                    else board[i][j]=0;
                }
            }
        }
    }
}
