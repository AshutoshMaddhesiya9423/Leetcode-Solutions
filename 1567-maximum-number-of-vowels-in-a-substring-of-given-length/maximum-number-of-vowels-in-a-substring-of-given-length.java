import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> st = new HashSet<>();
        st.add('a');
        st.add('e');
        st.add('i');
        st.add('o');
        st.add('u');
        
        int count = 0;
        int max = 0;
        
        
        for (int i = 0; i < k; i++) {
            if (st.contains(s.charAt(i))) {
                count++;
            }
        }
        
        max = count;
        
        
        for (int i = k; i < s.length(); i++) {
          
            if (st.contains(s.charAt(i - k))) {
                count--;
            }
            
            
            if (st.contains(s.charAt(i))) {
                count++;
            }
            
            max = Math.max(max, count);
        }
        
        return max;
    }
}
