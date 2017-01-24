public class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;
        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) rows[i]=new StringBuilder();
        int row=0;
        boolean down=true;
        for(int i=0;i<s.length();i++){
            rows[row].append(s.charAt(i));
            if(down)row++;
            else row--;
            if(row==numRows){
                down=false;
                row=numRows-2;
            }
            if(row==-1){
                down=true;
                row=1;
            }
        }
        StringBuilder res=new StringBuilder();
        for(StringBuilder strb:rows){
            res.append(strb);
        }
        return res.toString();
    }
}
