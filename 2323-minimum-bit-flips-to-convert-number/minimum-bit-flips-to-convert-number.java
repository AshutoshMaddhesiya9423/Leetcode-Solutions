class Solution {
    public int minBitFlips(int start, int goal) {
    String res1 = fun(start);
    String res2 = fun(goal);
    int count=0;
    for(int i=0;i<res1.length();i++){
        if(res1.charAt(i)!=res2.charAt(i)){
            count++;
        }
    }
    return count;
        }
    
    private static String fun(int n){
        StringBuilder sb = new StringBuilder();

        // Assuming 32-bit integer
        for (int i = 31; i >= 0; i--) {
            int bit = (n >> i) & 1;  // get the i-th bit
            sb.append(bit);
        }
        String result = sb.toString();
        return result;
    }
}