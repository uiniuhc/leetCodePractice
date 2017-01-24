public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int[][] numIs=new int[nums.length][2];
        for(int i=0;i<numIs.length;i++){
            numIs[i][0]=nums[i];numIs[i][1]=i;
        }
        Arrays.sort(numIs,new Comparator<int[]>(){public int compare(int[]a,int[]b) {return a[0]-b[0];}});
        HashMap<Integer,int[]> inlist=new HashMap<Integer,int[]>();
        for(int i=0;i<numIs.length;i++){
            if(inlist.containsKey(numIs[i][0])){inlist.get(numIs[i][0])[1]=i;}
            else{int[] t=new int[2];t[0]=i;t[1]=i;inlist.put(numIs[i][0],t);}
        }
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        for(int i=0;i<numIs.length;){
            for(int j=i+1;j<nums.length;){
                int sum=-(numIs[i][0]+numIs[j][0]);
                if(inlist.containsKey(sum)){
                    int k=inlist.get(sum)[1];
                    if(k>j)res.add(genList(numIs[i][0],numIs[j][0],numIs[k][0]));
                }
                //update j
                int currJ=numIs[j][0];
                while(j<numIs.length && numIs[j][0]==currJ)j++;
            }
            int currI=numIs[i][0];
            while(i<numIs.length && numIs[i][0]==currI)i++;
            
        }
        return res;
    }
    private List<Integer> genList(int i,int j,int k){
        List<Integer> list=new ArrayList<Integer>();
        list.add(i);list.add(j);list.add(k);
        return list;
    }
}
