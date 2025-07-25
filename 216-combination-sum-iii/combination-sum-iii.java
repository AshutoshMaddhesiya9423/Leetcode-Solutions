class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>> result = new ArrayList<>();
         
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;  
    }
     private void backtrack(int element, int target, int k, List<Integer> path, List<List<Integer>> result) {
        if(path.size()>=k){
        if (target == 0) {
            result.add(new ArrayList<>(path));
            }
            return;
        }
        

        for (int el= element; el <=9; el++) {
           
           

            
            if (el <= target) {

            path.add(el);
            backtrack(el+1, target -el, k, path, result); 
            path.remove(path.size() - 1);
            }
        }
    }
}