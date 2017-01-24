public class Solution {
    private boolean isPalindrome(String w){
        if(w.length()<2){
            return true;
        }
        int i=0;
        int j=w.length()-1;
        while(i<j){
            if(w.charAt(i)!=w.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int empty=-1;
        ArrayList<Integer> palindrome=new ArrayList<Integer>();
        HashMap<String,Integer> allStrings=new HashMap<String,Integer>();
        
        String[] rwords=new String[words.length];
        //init and index
        for(int k=0;k<words.length;k++){
            String str=words[k];
            allStrings.put(words[k],k);
        }
        for(int k=0;k<words.length;k++){
            String str=words[k];
            StringBuilder preBuilder=new StringBuilder();
            StringBuilder sufBuilder=new StringBuilder();
            for(int l=-1;l<str.length();l++){
                if(l>=0){
                    preBuilder.insert(0,str.charAt(l));
                    sufBuilder.append(str.charAt(str.length()-1-l));
                }
                String pre=preBuilder.toString();
                
                if(allStrings.containsKey(pre)){
                    //check rest
                    String rest=str.substring(l+1);
                    if(isPalindrome(rest)){
                        int j=allStrings.get(pre);
                        if(words[k].length()!=words[j].length() ||
                        (words[k].length()==words[j].length() && k<j)){
                            ArrayList<Integer> tpair=new ArrayList<Integer>();
                            tpair.add(k);tpair.add(j);
                            res.add(tpair);
                        }
                    }
                }
                String suf=sufBuilder.toString();
                if(allStrings.containsKey(suf)){
                    //check rest
                    String rest=str.substring(0,str.length()-l-1);
                    
                    if(isPalindrome(rest)){
                        int j=allStrings.get(suf);
                        if(words[k].length()!=words[j].length() ||
                        (words[k].length()==words[j].length() && k<j)){
                            ArrayList<Integer> tpair=new ArrayList<Integer>();
                            tpair.add(j);tpair.add(k);
                            res.add(tpair);
                        }
                    }
                }
            }
        }
        return res;
    }

}
