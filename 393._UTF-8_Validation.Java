public class Solution {
    
    public boolean validUtf8(int[] data) {
        if( 0 == data.length)return true;
        int i=0;
        while(i<data.length){
            int l=getLen(data[i])-1;
            if(l<0)return false;
            if(l+i>=data.length){
                return false;
            }
            while(l-->0){
                i++;
                if(!isFollower(data[i])){
                    return false;
                }
            }
            i++;
        }
        return true;
    }
    private int getLen(int n){
        n=n & 0xff;
        //get first bit!
        if(n>>7==0){
            return 1;
        }
        else if((n>>5) ==6){
            return 2;
        }
        else if((n>>4)==14){
            return 3;
        }else if((n>>3)==30){
            return 4;
        }
        return -1;
    }
    private boolean isFollower(int n){
        n=n & 0xff;
        if((n>>6)==2)return true;
        return false;
    }
}
