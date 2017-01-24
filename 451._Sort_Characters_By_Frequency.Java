public class Solution {
    public String frequencySort(String s) {
        int[][] count=new int[256][2];
        int k=0;
        for(int[] c:count) c[0]=k++;
        for(int i=0;i<s.length();i++){
            int index=(int) s.charAt(i);
            count[index][1]++;
        }
        Arrays.sort(count,
        new Comparator<int[]>() 
        {public int compare(int[]a,int[]b)
        {return b[1]-a[1];}
        });
        StringBuilder strb=new StringBuilder();
        for(int[] c:count){
            while(c[1]-->0){
                strb.append((char)c[0]);
            }
        }
        return strb.toString();
    }
}
