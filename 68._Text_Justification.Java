public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        //arrange for lines
        
        int currLen=0;
        Queue<String> que=new LinkedList<String>();
        List<String> res=new ArrayList<String>();
        if(words.length==0)return res;
        if(words.length==1){
            StringBuilder strb=new StringBuilder();strb.append(words[0]);
            while(strb.length()<maxWidth)strb.append(" ");
            res.add(strb.toString());return res;}
        que.add(words[0]);
        currLen=words[0].length();
        for(int i=1;i<=words.length;i++){
            String str="";if(i<words.length)str=words[i];
            //select enough words
            if(str.length()+currLen+que.size()>maxWidth||i==words.length){
                res.add(justString(que,maxWidth,i==words.length,currLen));
                currLen=str.length();que.add(str);
            }else{
                //normal state
                currLen+=str.length();que.add(str);
            }
        }
        return res;
    }
    private String justString(Queue<String> que,int maxWidth,boolean isLast,int len){
        int space=1;
        int remainder=0;
        //if(que.size()==1)space=0;
        if(!isLast && que.size()>1){
            space=(maxWidth-len)/(que.size()-1);
            remainder=(maxWidth-len)%(que.size()-1);
        }
        StringBuilder strb=new StringBuilder();
        while(!que.isEmpty()){
            String next=que.poll();
            strb.append(next);
            if(!que.isEmpty()){
                for(int i=0;i<space;i++)strb.append(" ");
                if(remainder>0){strb.append(" ");remainder--;}
            }
        }
        while(strb.length()<maxWidth)strb.append(' ');
        return strb.toString();
    }
}
