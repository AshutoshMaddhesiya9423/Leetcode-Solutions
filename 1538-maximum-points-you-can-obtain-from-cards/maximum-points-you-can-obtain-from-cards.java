class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int ans = 0;
        
       
        for (int i = 0; i < k; i++) {
            ans += cardPoints[i];
        }

        int maxSum = ans;

       
        for (int i = 1; i <= k; i++) {
            ans -= cardPoints[k - i];          
            ans += cardPoints[n - i];          
            maxSum = Math.max(maxSum, ans);
        }

        return maxSum;
    }
}
