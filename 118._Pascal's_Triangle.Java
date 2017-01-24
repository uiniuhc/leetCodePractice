public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows==0) return res;
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> l=new ArrayList<Integer>();
            l.add(1);
            if(i>0){
                List<Integer> last=res.get(i-1);
                for(int k=0,j=1;j<last.size();k++,j++){
                    l.add(last.get(k)+last.get(j));
                }
                l.add(1);}
            res.add(l);
        }
        return res;
    }
}
