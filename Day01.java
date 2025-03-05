 QUES ->303. Range Sum Query - Immutable

class NumArray {
     private int prefix[];
    public NumArray(int[] nums) {
        for(int i =1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        this.prefix = nums;
    }
    
    public int sumRange(int left, int right) {
        if(left==0 ){
            return prefix[right];

        }
        return (prefix[right] - prefix[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

QUES -> 1480. Running Sum of 1d Array

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int [] prefix = new int [n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]= prefix[i-1] + nums[i];
        }
        return prefix;
    }
}

QUES-> 560. Subarray Sum Equals K

class Solution {
    public int subarraySum(int[] nums, int k) {
   int n = nums.length;
   int count =0;
   int[] prefix = new int [n];
   for(int i=0;i<n;i++){
    prefix[i]=0;
   }
   prefix[0]=nums[0];
   for(int i=1;i<n;i++){
    prefix[i]=prefix[i-1]+nums[i];
   }
   HashMap<Integer, Integer> map = new HashMap<>();
       
        for(int j =0;j<n;j++){
           if(prefix[j]==k){
            count ++;
           }
           int val = prefix[j]-k;
           if(map.containsKey(val)){
            count +=map.get(val);
           }
           if(!map.containsKey(val)){
                map.put(val,0);
            }
            map.put(prefix[j], map.getOrDefault(prefix[j], 0) + 1);
    }
    return count;
}
}