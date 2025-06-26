class Solution {
    public int subarraysDivByK(int[] nums, int k) {
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
   map.put(0, 1);
       
        for(int j =0;j<n;j++){
           int val =((prefix[j]%k)+k)%k;
           if(map.containsKey(val)){
            count +=map.get(val);
           }
          
            map.put(val, map.getOrDefault(val, 0) + 1);
    }
    return count;
}
    }
