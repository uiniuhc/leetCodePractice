/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long l=1;long r=n;
        long mid=0;
        while(l<=r){
            mid=(l+r)/2;
            int res=guess((int)mid);
            if(res==0){
                return (int)mid;
            }else if(res<0){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return 0;
    }
}
