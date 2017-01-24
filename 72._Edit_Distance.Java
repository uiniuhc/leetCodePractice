public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)return word2.length();
        if(word2.length()==0)return word1.length();
        char [] w1=word1.toCharArray();
        char [] w2=word2.toCharArray();
        int [][] opt=new int[w1.length+1][w2.length+1];//align size w1 to w2
        //init
        for(int i=0;i<=w1.length;i++){
            opt[i][0]=i;
        }
        for(int i=0;i<=w2.length;i++){
            opt[0][i]=i;
        }
        for(int i=1;i<=w1.length;i++){
            for(int j=1;j<=w2.length;j++){
                if(w1[i-1]==w2[j-1])
                    opt[i][j]=opt[i-1][j-1];
                else{
                    int min=opt[i-1][j]+1;
                    if(opt[i-1][j-1]+1<min)min=opt[i-1][j-1]+1;
                    if(opt[i][j-1]+1<min)min=opt[i][j-1]+1;
                    opt[i][j]=min;
                }
            }
        }
        return opt[w1.length][w2.length];
        
    }
}
