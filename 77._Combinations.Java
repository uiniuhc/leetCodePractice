public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new LinkedList<List<Integer>>();
        if(k==0 || n<k)return res;
        //iterative solution
        List<Integer> init=new ArrayList<Integer>();
        for(int i=1;i<=k;i++) init.add(i);
        res.add(init);
        boolean isMax=false;
        List<Integer> last=init;
        while(true){
            //add from last digit
            int currDigit=k-1;
            List<Integer> list=new ArrayList<Integer>(last);
            //get digit need update
            while(currDigit>=0 && list.get(currDigit)==n-(k-currDigit)+1){
                currDigit--;
            }
            if(currDigit==-1) break;
            //update list
            int from=list.get(currDigit)+1;
            list.set(currDigit,from);
            for(int i=currDigit+1;i<k;i++){
                list.set(i,++from);
            }
            res.add(list);
            last=list;
        }
        return res;
    }

}
