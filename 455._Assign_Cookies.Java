public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int pcookie=s.length-1;
        int pchild=g.length-1;
        while(pcookie>=0 && pchild >=0){
            if(s[pcookie]>=g[pchild]){
                pcookie--;pchild--;
                count++;
            }else{
                pchild--;
            }
        }
        return count;
    }
}
