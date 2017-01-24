public class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        if(citations.length==0){
            return 0;
        }
        Arrays.sort(citations);
        if(citations[citations.length-1]==0){
            return 0;
        }
        if(citations.length==1){
            return 1;
        }
        int res=0;
        //from the last one to count
        for(int i=1;i<=citations.length;i++){
            //the last i papers are larger than i times citations
            //and the paper before that one has less than i
            if(n-i-1>=0 && citations[n-i-1]>i)continue;
            if(citations[n-i]<i)continue;
            res=i;
        }
        return res;
    }
}
