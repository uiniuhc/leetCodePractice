public class Solution {
    public int trap(int[] height) {
        if(height.length<=2)return 0;
        int lastMax=0;
        int res=0;
        int tmp=0;
        for(int i=0;i<height.length;i++){
            if(height[i]<lastMax){
                tmp+=lastMax-height[i];
            }else{
                res+=tmp;
                tmp=0;
                lastMax=height[i];
            }
        }
        int rightMax=0;tmp=0;
        for(int i=height.length-1;i>=0;i--){
            if(height[i]<rightMax){
                tmp+=rightMax-height[i];
            }else{
                //no fence
                res+=tmp;
                tmp=0;
                rightMax=height[i];
                if(rightMax==lastMax)return res;
            }
        }
        return res;
    }
}
