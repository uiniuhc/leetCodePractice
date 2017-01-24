public class Solution {
    public String reverseVowels(String s) {
        char[] charArray=s.toCharArray();
        Stack<Character> chs=new Stack<Character>();
        char ch;
        for(int i=0;i<s.length();i++){
            ch=charArray[i];
            if(ch=='a' || ch=='e' || ch=='i'||ch=='o'||ch=='u'||
            ch=='A' || ch=='E' || ch=='I'||ch=='O'||ch=='U'){
                chs.push(ch);
            }
        }
        for(int i=0;i<s.length();i++){
            ch=charArray[i];
            if(ch=='a' || ch=='e' || ch=='i'||ch=='o'||ch=='u'||
            ch=='A' || ch=='E' || ch=='I'||ch=='O'||ch=='U'){
                charArray[i]=chs.pop();
            }
        }
        return new String(charArray);
    }
}
