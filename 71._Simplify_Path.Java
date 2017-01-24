public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> sequence=new LinkedList<String>();
        String[] elements=path.split("/");
        for(String str:elements){
            if(str.trim().length()==0)continue;
            if(str.trim().equals("."))continue;
            if(str.trim().equals("..")){
                if(sequence.size()>0){
                    sequence.removeLast();
                }
                continue;
            }
            sequence.add(str);
        }
        if(sequence.size()==0)return "/";
        String res="";
        
        //construct
        for(String str:sequence){
            res=res+"/"+str;
        }
        return res;
    }
}
