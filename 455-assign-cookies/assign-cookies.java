class Solution {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
       Arrays.sort(s);  
         int n= g.length;
         int m = s.length;
         int i=0;
         int j=0;
         int count=0;
         while(j<m&&i<n){
            if(s[j]>=g[i]){
                count++;
                i++;
            }
            
            j++;
         }   
  return count;
    }
}