public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0)return true;
        if(board.length==0 || board[0].length==0)return false;
        LinkedList<Pair> path=new LinkedList<Pair>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) ){
                    path.addLast(new Pair(i,j));
                    if( dfs(board,i,j,word,path))return true;
                    path.removeLast();
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][]board,int x,int y,String word,LinkedList<Pair> path){
        int nowLen=path.size();
        if(nowLen==word.length())return true;
        //if(nowLen>word.length())return false;
        char next=word.charAt(nowLen);
        //search neighbors
        if(dfsHelper(board,x-1,y,next,path,word))return true;
        if(dfsHelper(board,x,y-1,next,path,word))return true;
        if(dfsHelper(board,x+1,y,next,path,word))return true;
        if(dfsHelper(board,x,y+1,next,path,word))return true;
        return false;
    }
    class Pair{
        public int x;
        public int y;
        Pair(int tx,int ty){x=tx;y=ty;}
    }
    private boolean notInPath(int x, int y, LinkedList<Pair> path){
        for(Pair p:path){
            if(p.x==x && p.y ==y)return false;
        }
        return true;
    }
    private boolean dfsHelper(char[][]board, int x, int y, char next, LinkedList<Pair> path,String word){
        if(x<0 || x>=board.length || y<0 ||y>=board[0].length)return false;
        if( board[x][y]==next && notInPath(x,y,path)){
            path.addLast(new Pair(x,y));
            boolean res=dfs(board,x,y,word,path);
            if(res)return true;
            path.removeLast();
        }
        return false;
    }

}
