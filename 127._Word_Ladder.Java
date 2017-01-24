public class Solution {
     public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //use bfs to search the shortest path
        if(beginWord.equals(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<String>();
        Queue<Integer> counts=new LinkedList<Integer>();
        Set<String> used=new HashSet<String>();
        boolean found=false;
        char tmp;
        int count=0;
        used.add(beginWord);
        q.add(beginWord);
        counts.add(count);
        while(!found && !q.isEmpty()){
            String using=q.poll();
            StringBuilder strb=new StringBuilder(using);
            count=counts.poll();
            count++;
            //change for 1 char
            for(int j=0;j<using.length() && !found;j++){
                tmp=using.charAt(j);
                //change for 1 char
                for(char i='a';i<='z' && !found;i++){
                    if(i!=tmp ){
                        strb.setCharAt(j, i);
                        String ss=strb.toString();
                        if(ss.equals(endWord)){
                            found=true;
                            return count+1;
                        }
                        else if(used.contains(ss)){
                            continue;
                        }else if(wordList.contains(ss)){
                            q.add(ss);
                            used.add(ss);
                            counts.add(count);
                        }
                    }
                }
                strb.setCharAt(j, tmp);
            }
            
        }
        
        return 0;
    }
}
