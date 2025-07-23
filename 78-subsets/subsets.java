class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        fun(nums,temp, res,0 );
        return res;
    }
    private static void  fun(int [] nums,List<Integer> temp, List<List<Integer>> result, int i){
        if(i==nums.length){
            result.add(new ArrayList<Integer>(temp));
            return;
            
        }
        temp.add(nums[i]);
        fun(nums, temp, result, i+1);
        temp.remove(temp.size()-1);
        fun(nums, temp, result, i+1);
    }
}