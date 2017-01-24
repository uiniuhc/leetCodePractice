public class Solution {
    String[] letters={" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<String>();
        if(digits.length()==0)return res;
        oneDigitHelper("",0,digits,res);
        return res;
    }
    private void oneDigitHelper(String curr,int index,String digits,List<String> res){
        if(index==digits.length()){
            res.add(curr);
            return;
        }
        String candidates=letters[digits.charAt(index)-'0'];
        for(char ch:candidates.toCharArray()){
            oneDigitHelper(curr+ch,index+1,digits, res);
        }
    }
    
}
