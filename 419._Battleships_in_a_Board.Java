public class Solution {
    public int countBattleships(char[][] board) {
        int count=0;
        if(board.length==0 || board[0].length==0)return 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.' && isTheFirst(board,i,j))count++;
            }
        }
        return count;
    }
    private boolean isTheFirst(char[][] board,int x,int y){
        if(x>0 && board[x-1][y]!='.')return false;
        if(y>0 && board[x][y-1]!='.')return false;
        return true;
    }
}
