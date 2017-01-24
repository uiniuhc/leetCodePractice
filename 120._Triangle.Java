public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] lastRowMin=new int[triangle.size()];
        int[] nowRowMin=new int[triangle.size()];
        int min=0;
        for(int i=0;i<triangle.size();i++){
            List<Integer> l=triangle.get(i);
            for(int j=0;j<l.size();j++){
                int ml,mr;
                int curr=l.get(j);
                if(j==0){
                    nowRowMin[0]=lastRowMin[0]+curr;
                }
                else if(j==l.size()-1){
                    nowRowMin[l.size()-1]=lastRowMin[l.size()-2]+curr;
                }
                else{
                    ml=lastRowMin[j-1];
                    mr=lastRowMin[j];
                    nowRowMin[j]=ml<mr?ml+curr:mr+curr;
                }
            }
            for(int j=0;j<l.size();j++){
                lastRowMin[j]=nowRowMin[j];
            }
        }
        min=nowRowMin[0];
        for(int i=0;i<triangle.size();i++){
            if(min>nowRowMin[i]){
                min=nowRowMin[i];
            }
        }
        return min;
    }
}
