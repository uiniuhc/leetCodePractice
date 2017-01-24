public class Solution {
    public List<Integer> lexicalOrder(int n) {
        int curr=1;
        List<Integer> res=new ArrayList<Integer>();
     
        while(true){
           if(res.size()>=n)break;
           
        //first times 10 until n
            while(curr<=n){
                res.add(curr);
                curr*=10;
            }
        //then add one
            curr/=10;
            curr++;
            if(curr%10==0){
                curr/=10;
                continue;
            }
            int count=curr%10;
            
            while(curr<=n && count<10){
                res.add(curr);
                curr++;count++;
            }
            if(curr>n){
                curr--;
                curr/=10;
                curr++;
            }
            while(curr%10==0) curr/=10;
            
        }
        return res;

    }
}
