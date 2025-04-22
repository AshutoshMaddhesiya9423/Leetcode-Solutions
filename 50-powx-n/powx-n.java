class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        long N=n;
       if(N<0){
        x= 1/x;
        N =-N;
       }
       
        double ans = myPow(x ,(int)(N / 2));
        ans = ans*ans;
    
    if(N%2==1){
        return ans*x;
    }
    return ans;
}
}