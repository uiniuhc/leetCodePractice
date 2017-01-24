public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> ss=new Stack<Integer>();

        if(heights.length==0){
            return 0;
        }
        int curr=-1;
        int max=0;      
        for(int i=0;i<=heights.length;i++){
            if(i<heights.length && heights[i]>=curr){
                //push
                curr=heights[i];
                ss.push(heights[i]);
            }
            else{
                //pop all until get the 
                int count=0;
                int tt=0;
                if(i<heights.length){
                    tt=heights[i];
                }else{
                    tt=0;
                }
                while(!ss.empty() &&ss.peek()>tt){
                    count++;
                    int a=ss.pop();
                    if(a*count>max){
                        max=a*count;
                    }
                }
                //insert the new one
                while(count-->=0){
                    ss.push(tt);
                }
            }
        }
        return max;
    }
}
