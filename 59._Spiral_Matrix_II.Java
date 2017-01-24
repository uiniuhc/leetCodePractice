public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<0)return null;
        int[][] res=new int[n][n];
        int count=0;
        int x=0;
        int y=-1;
        int last_d=0;
        while(count!=n*n){
            //search according to last direction
            switch(last_d){
                case 1:
                    if(x+1>=n || res[x+1][y]!=0){
                        last_d++;last_d=last_d%4;
                    }else{
                        count++;
                        res[x+1][y]=count;x++;
                    }
                    break;
                case 0:
                    if(y+1>=n || res[x][y+1]!=0){
                        last_d++;last_d=last_d%4;
                    }else{
                        count++;
                        res[x][y+1]=count;y++;
                    }
                    break;
                case 3:
                    if(x-1<0 || res[x-1][y]!=0){
                        last_d++;last_d=last_d%4;
                    }else{
                        count++;
                        res[x-1][y]=count;x--;
                    }
                    break;
                case 2:
                    if(y-1<0 || res[x][y-1]!=0){
                        last_d++;last_d=last_d%4;
                    }else{
                        count++;
                        res[x][y-1]=count;y--;
                    }
                    break;
            }
        }
        return res;
        
    }
}
