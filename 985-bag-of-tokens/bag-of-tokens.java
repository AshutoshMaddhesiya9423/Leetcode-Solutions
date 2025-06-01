class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i=0, j=tokens.length-1, s=0, ans=0;
        while(i<=j){
            if(power>=tokens[i]){
                power = power-tokens[i];
                i++;
                s++;
                ans = Math.max(ans, s);
            } else if(s>0){
                power = power+tokens[j];
                j--;
                s--;
            } else{
                break;
            }
            
        
       
    }
           
          return ans; 
}
}