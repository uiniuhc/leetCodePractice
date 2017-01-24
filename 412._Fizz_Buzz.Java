public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<String>();
        int count_fizz=1;
        int count_buzz=1;
        for(int i=1;i<=n;i++,count_fizz++,count_buzz++){
            if(count_fizz==3 && count_buzz==5){
                res.add("FizzBuzz");
                count_fizz=0;count_buzz=0;
            }else if(count_fizz==3){
                res.add("Fizz");count_fizz=0;
            }else if(count_buzz==5){
                res.add("Buzz");count_buzz=0;
            }else{
                res.add(""+i);
            }
            
        }
        return res;
    }
}
