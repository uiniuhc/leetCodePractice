public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime=new boolean[n];
        int lastPrime=2;//prime number
        while(lastPrime<n){
            int p=lastPrime*2;
            while(p<n){
                notPrime[p]=true;
                p+=lastPrime;
            }
            
            //find next prime
            do{
                lastPrime++;
                if(lastPrime<n && !notPrime[lastPrime])break;
            }while(lastPrime<n);
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(!notPrime[i])count++;
        }
        return count;
        
    }
}
