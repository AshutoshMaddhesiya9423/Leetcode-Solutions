class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int [] heights = new int[matrix[0].length];
        int ans=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val = matrix[i][j]-'0';
                if(val==0){
                    heights[j]=0;
                }
                else{
                    heights[j] += val;
                }
            }
            int max = largestRectangleArea(heights);
            if(ans<max){
                ans =max;
            }
        }
        return ans;
    }
        private int  largestRectangleArea(int[] heights) {
        int n= heights.length;
        int [] ns=  nextsmaller(heights);
        int [] ps = prevsmaller(heights);
        int max= Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int h= heights[i];
            int w = ns[i] - ps[i] -1;
            max= Math.max(max, (h*w));
        }
        return max;
        
    }
    private int [] nextsmaller(int [] nums){
        int n = nums.length;
        Stack<Integer>stack= new Stack<>();
        int [] res = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]>=nums[i]){
                stack.pop();

            }
            if(stack.isEmpty()){
                res[i]=n;
            } else{
                res[i]=stack.peek();
            }
            stack.push(i);

        }
        return res;
    }
     private int [] prevsmaller(int [] nums){
        int n = nums.length;
        Stack<Integer> stack= new Stack<>();
        int [] res = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]>=nums[i]){
                stack.pop();

            }
            if(stack.isEmpty()){
                res[i]=-1;
            } else{
                res[i]=stack.peek();
            }
            stack.push(i);

        }
        return res;
    }
}