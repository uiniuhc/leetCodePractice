public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map=new HashMap<Integer, List<List<Integer>>>();
        List<List<Integer>> res=new  ArrayList<List<Integer>>();
        //first make all numbers into 2 numbers
        //make the hashmap for future use
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(map.containsKey(nums[i]+nums[j])){
                    List<List<Integer>> list=map.get(nums[i]+nums[j]);
                    ArrayList<Integer> twoNum=new ArrayList<Integer>();
                    twoNum.add(i);twoNum.add(j);
                    list.add(twoNum);
                }else{
                    ArrayList<Integer> twoNum=new ArrayList<Integer>();
                    twoNum.add(i);twoNum.add(j);
                    List<List<Integer>> list=new ArrayList<List<Integer>>();
                    list.add(twoNum);
                    map.put(nums[i]+nums[j],list);
                }
            }
        }
        HashSet<String> sols=new HashSet<String>();
        //now start finding the answers
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                int dif=target-sum;
                if(map.containsKey(dif)){
                    //possible answers in here
                    List<List<Integer>> list=map.get(dif);
                    for(List<Integer> curr:list){
                        if(curr.get(0)!=i && curr.get(0)!=j && curr.get(1)!=i && curr.get(1)!=j){
                            List<Integer> sol=new ArrayList<Integer>();
                            sol.add(nums[i]);
                            sol.add(nums[j]);
                            sol.add(nums[curr.get(0)]);
                            sol.add(nums[curr.get(1)]);
                            Collections.sort(sol);
                            String s="";
                            for(int ii:sol){
                                s=s+ii+" ";
                            }
                            if(!sols.contains(s)){
                                res.add(sol);
                                sols.add(s);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
