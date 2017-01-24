public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("[.]");
        String[] v2=version2.split("[.]");
        for(int i=0;i<v1.length || i<v2.length;i++){
            int i1=0;int i2=0;
            if( i< v1.length){ 
                i1=Integer.parseInt(v1[i]);}
            if( i < v2.length){ i2=Integer.parseInt(v2[i]);}
            if(i1>i2) return 1;
            else if(i2>i1) return -1;
        }
        return 0;
    }
}
