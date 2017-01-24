public class Solution {
    private void seedFill(char[][] board,boolean [][] used,int x,int y){
        Queue<Integer> xque=new Queue<Integer>();
        Queue<Integer> yque=new Queue<Integer>();
        xque.add(x);
        yque.add(y);
        while(!xque.isEmpty()){
            int tx=xque.poll();
            int ty=xque.poll();
            board[tx][ty]='X';
            used[tx][ty]=true;
            if(board[tx-1][ty]=='O'){xque.add(tx-1);yque.add(ty);}
            if(board[tx][ty-1]=='O'){xque.add(tx);yque.add(ty-1);}
            if(board[tx+1][ty]=='O'){xque.add(tx+1);yque.add(ty);}
            if(board[tx][ty+1]=='O'){xque.add(tx);yque.add(ty+1);}
        }
    }
    //find circle if there is one, pos will be set to the first O inside it
    private void circleFind(char[][] board,boolean[][]used,int x,int y,int[] pos){
        pos[0]=-1;pos[1]=-1;
        //dfs from x,y, if return, there is a cycle
    }
    public void solve(char[][] board) {
        if(board==null || board.length<=2||board[0].length<=2)return ;
        boolean[][] used=new boolean[board.length][board[0].length];
        int[] pos=new int[2];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(used[i][j])continue;
                //find a circle
                int tx=-1;int ty=-1;
                if(board[i][j]=='X'){
                    //start finding
                    used[i][j]=true;
                    //8 directions, counterclockwise
                    circleFind(board,used,i,j,pos);
                    //find an O inside this circle
                    tx=pos[0];ty=pos[1];
                }
                //fill with x
                if(tx>=1 && ty>=1){
                    seedFill(board,used,tx,ty)
                }
            }
        }
        
    }
}
