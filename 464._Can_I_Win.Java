public class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(desiredTotal==0)return true;
        //get max
        int total=(1+maxChoosableInteger)*maxChoosableInteger;
        if(total%2==1)total=(total+1)/2;
        else total=total/2;
        if(total<desiredTotal)return false;
        HashMap<Integer,Boolean> game=new HashMap<Integer,Boolean>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(0);l.add(desiredTotal);
        return helper(0,maxChoosableInteger,desiredTotal,game);
    }
    private boolean helper(int l,int m,int d,HashMap<Integer,Boolean> game){
        if(game.containsKey(l)){
            return game.get(l);
        }
        if(d<=0)return false;//former player win, i lost
        boolean res=false;
        //try every possibilities
        for(int i=0;i<m && !res;i++){
            if(0==((1<<i)&l)){
                l=(l|(1<<i));
                if(!helper(l,m,d-(i+1),game)){
                   res=true;
                }
                l=(l&(~(1<<i)));
            }
        }
        game.put(l,res);
        
        return res;
    }
}
