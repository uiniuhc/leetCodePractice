public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(checkRow(board,i,j)&&checkCol(board,i,j)&&checkBlock(board,i,j))continue;
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkRow(char[][] board,int x, int y){
        for(int i=0;i<9;i++){
            if(i==x)continue;
            if(board[x][y]==board[i][y])return false;
        }
        return true;    
    }
    private boolean checkCol(char[][] board,int x,int y){
        for(int i=0;i<9;i++){
            if(i==y)continue;
            if(board[x][y]==board[x][i])return false;
        }
        return true;
    }
    private boolean checkBlock(char[][] board,int x,int y){
        int rx=(int)(x/3)*3;
        int ry=(int)(y/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(rx+i==x && ry+j==y)continue;
                if(board[rx+i][ry+j]==board[x][y])return false;
            }
        }
        return true;
    }
}
