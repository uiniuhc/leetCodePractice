public class Solution {
    public int integerReplacement(int n) {
        //Map<Long,Integer> map=new HashMap<Long,Integer>();
        return integerHelper(n);
    }
    private int integerHelper(long n){
        //if(map.containsKey(n))return map.get(n);
        int res=0;
        if(n==1)return 0;
        if(n%2==0){
            //map.put(n,1+integerHelper(n/2,map));
            res=1+integerHelper(n/2);
        }
        if(n%2==1){
            int t1=integerHelper(n-1);
            int t2=integerHelper(n+1);
            int temp=t1<t2?t1:t2;
            res=temp+1;
        }
        return res;
    }
}
