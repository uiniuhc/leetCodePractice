public class Solution {
    public boolean isUgly(int num) {
        if(num==0)return false;
        //check for 2 3 5
        while(num%2==0){
            num/=2;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%5==0){
            num/=5;
        }
        return num==1;
        
    }
}
