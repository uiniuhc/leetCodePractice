public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long a1=(long)(C-A)*(long)(D-B);
        long a2=(long)(G-E)*(long)(H-F);
        return (int)(a1+a2-getLen(A,C,E,G)*getLen(B,D,F,H));
    }
    private boolean inRange(int A,int C, int x){
        if(x<A || x>C)return false;
        return true;
    }
    private int getLen(int A,int C, int E, int G){
        int cutX=0;
        if((C-A)<(G-E))return getLen(E,G,A,C);
        if(inRange(A,C,E) && inRange(A,C,G)){
            cutX=G-E;
        }else if(inRange(A,C,E)){
            cutX=C-E;
        }else if(inRange(A,C,G)){
            cutX=G-A;
        }
        return cutX;
    }
}
