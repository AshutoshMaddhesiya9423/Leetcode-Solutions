class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int ans = 0;
        
        // Take all k cards from the left initially
        for (int i = 0; i < k; i++) {
            ans += cardPoints[i];
        }

        int maxSum = ans;

        // Now slide the window: take some from right, remove from left
        for (int i = 1; i <= k; i++) {
            ans -= cardPoints[k - i];          // remove from left
            ans += cardPoints[n - i];          // add from right
            maxSum = Math.max(maxSum, ans);
        }

        return maxSum;
    }
}
