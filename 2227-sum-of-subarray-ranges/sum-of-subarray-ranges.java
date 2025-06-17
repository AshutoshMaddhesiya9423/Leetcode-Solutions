class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
        
    }
      public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int [] nextsmall = nextsmall(arr, n);
        int [] prevsmall = prevsmall(arr, n);
        
        long count =0;
        for(int i=0;i<n;i++){
            int first = i-prevsmall[i];
            int second = nextsmall[i] - i;
            long prod=first*second;
            prod= prod * arr[i];
            count = count +prod;
        }
        
        return count;
    }
      public long sumSubarrayMaxs(int[] arr) {
        int n = arr.length;
        int [] nextsmall = nextgreater(arr, n);
        int [] prevsmall = prevgreater(arr, n);
         
        long count =0;
        for(int i=0;i<n;i++){
            int first = i-prevsmall[i];
            int second = nextsmall[i] - i;
            long prod=first*second;
            prod= prod * arr[i];
            count = count +prod;
        }
        
        return count;
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
    private static int [] nextgreater(int [] arr, int n){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int [n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
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
    private static int [] prevgreater(int [] arr, int n){
        Stack<Integer> st = new Stack<>();
        int [] ans = new int [n];
        for(int i=0;i<n;i++){
            
              while(!st.isEmpty()&&arr[st.peek()]<arr[i]){
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