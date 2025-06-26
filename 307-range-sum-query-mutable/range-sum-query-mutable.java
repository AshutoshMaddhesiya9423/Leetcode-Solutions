class NumArray {
  private int [] arr;
  private int [] st;
  int n ;
    public NumArray(int[] nums) {
        int N = nums.length;
        this.n= N;
        this.arr= nums;
        st = new int [4*n];
        if(n>0){
            build(0, 0, n-1);
        }
    }
    private void build(int i, int left, int right ){
        if(left==right){
            st[i]= arr[left];
            return ;
        }
        int mid = (left+right)/2;
        build(2*i+1, left, mid);
        build(2*i+2, mid+1, right);
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }
    
    public void update(int index, int val) {
        if(n>0){
            upDate(0,0,n-1, index, val );
        }
    }
     private void upDate(int i,int left, int right, int idx, int val){
        if(left==right){
            st[i]= val;
            arr[idx]= val;
            return ;
        }
         int mid = (left+right)/2;
         if(idx<=mid){
        upDate(2*i+1, left, mid, idx, val);
        }
        else{
        upDate(2*i+2, mid+1, right, idx, val);}
        st[i] = st[2*i+1] + st[2*i+2];
        
    }
    
    public int sumRange(int left, int right) {
        if(n==0){
            return 0;

        }
        return query(0, 0, n-1, left, right);

        
    }
    private  int query(int i, int start, int end, int l, int r){
        if(l<=start&&end<=r){
            return st[i];

        }
        if(r<start||end<l){
            return 0;
        }
        int mid =(start+end)/2;
        int lt = query(2*i+1, start, mid ,l, r);
        int rt = query(2*i+2, mid+1, end, l, r);
        return lt+rt;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */