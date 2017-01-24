public class Solution {
    public int addDigits(int num) {
        if(num<9 || num%9!=0)
            return num%9;
        else
            return 9;
    }
}
