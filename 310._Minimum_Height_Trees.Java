public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<Integer>());
        int[] counts=new int[n];
        for(int[] edge:edges){
            int i=edge[0];int j=edge[1];
            adj.get(j).add(i);
            adj.get(i).add(j);
            counts[i]++;counts[j]++;
        }
        int removed=0;
        LinkedList<Integer> currOne=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            if(counts[i]<=1)currOne.add(i);
        }
        while(currOne.size()+removed<n){
            int time=currOne.size();
            while(time-->0){
                int node=currOne.removeFirst();
                removed++;
                //delete edges
                ArrayList<Integer> es=adj.get(node);
                if(es!=null){
                    for(int k:es){
                        counts[k]--;
                        if(counts[k]==1)currOne.add(k);
                    }
                }
            }
        }
        return currOne;
    }
}
