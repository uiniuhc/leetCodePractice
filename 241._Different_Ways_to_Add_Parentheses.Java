public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<Integer>();
        boolean noOp=true;
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='+'||ch=='-'||ch=='*')
            {
                List<Integer> pre=diffWaysToCompute(input.substring(0,i));
                List<Integer> sur=diffWaysToCompute(input.substring(i+1));
                noOp=false;
                for(int p:pre){
                    for(int q:sur){
                        switch(ch){
                            case '+': res.add(p+q);
                                break;
                            case '-':res.add(p-q);
                                break;
                            case '*':res.add(p*q);
                                break;
                        }
                    }
                }
            }
        }
        if(noOp){
            res.add(Integer.parseInt(input));
        }
        return res;
    }
    
}
