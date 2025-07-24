class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        fun(candidates,temp, res,0, target );
        return res;
    }
    private static void  fun(int [] nums,List<Integer> temp, List<List<Integer>> result, int i, int target){
        if(i==nums.length){
        if(target==0){
            
            result.add(new ArrayList<Integer>(temp));
            return;}
            
        }
        if (i == nums.length || target < 0) return;
        temp.add(nums[i]);
        fun(nums, temp, result, i,target-nums[i]);
        temp.remove(temp.size()-1);
        fun(nums, temp, result, i+1, target);
    }
    
}