class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int [] nextsmall = nextsmall(arr, n);
        int [] prevsmall = prevsmall(arr, n);
         int mod = 1000000007;
        long count =0;
        for(int i=0;i<n;i++){
            int first = i-prevsmall[i];
            int second = nextsmall[i] - i;
            long prod=(first*second)%mod;
            prod= (prod * arr[i]%mod);
            count = (count%mod +prod)%mod;
        }
        
        return (int)count;
    }
    private static int [] nextsmall(int [] arr, int n){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int [n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                st.pop();
                }
               if(st.isEmpty()){
                ans[i]=n;
               }
               else{
                ans[i]=st.peek();
               }
              
            
            st.push(i);
        }
       return ans;
    }
    private static int [] prevsmall(int [] arr, int n){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int [n];
        for(int i=0;i<n;i++){
            
              while(!st.isEmpty()&&arr[st.peek()]>arr[i]){
                st.pop();
                }
               if(st.isEmpty()){
                ans[i]=-1;
               }
               else{
                ans[i]=st.peek();
               }
              
            
            st.push(i);
        }
        return ans;
    }
}