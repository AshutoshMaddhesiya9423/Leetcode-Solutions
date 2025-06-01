class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
      
        char[] charArray = palindrome.toCharArray();
        int i =0;
        while(i<n/2&&charArray[i]=='a'){
            ++i;
        }
        if(i==n/2){
            charArray[n-1]='b';
        } else{
      charArray[i]='a';
        }
        return new String(charArray);
    }
}