DP:
public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0||s.charAt(0)=='0') return 0;
        if(s.length()==1) return 1;
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            if(s.charAt(i-1)!='0') dp[i]=dp[i-1];
            if(isTwodigitNum(s.charAt(i-2),s.charAt(i-1)))
                dp[i]+=dp[i-2];
            if(dp[i]==0) return 0;
        }
        return dp[dp.length-1];
    }
    
    public boolean isTwodigitNum(char a, char b){
        int num=10*(a-'0')+b-'0';
        if(num>=10&&num<=26) return true;
        return false;
    }
}




public class Solution {
     public int numDecodings(String s) {
        ArrayList<Integer> solutions = new ArrayList<Integer>();
        if(s.length() != 0)
            recursion(s, solutions);
        return solutions.size();
    }
     
    private void recursion(String s, ArrayList<Integer> solutions) {
        if(s.length() == 0){
            solutions.add(1);
        } else {
            int value = Character.getNumericValue(s.charAt(0));
            if(value > 0 && value <= 9) {
                recursion(s.substring(1), solutions);
            }
             
            if(s.length() >= 2) {
                int value1 = Character.getNumericValue(s.charAt(0));
                int value2 = Character.getNumericValue(s.charAt(1));
                if(value1 == 1 && value2 >= 0 && value2 <= 9) {
                    recursion(s.substring(2), solutions);
                } else if(value1 == 2 && value2 >= 0 && value2 <= 6) {
                    recursion(s.substring(2), solutions); 
                }
            }
        }
    }
}