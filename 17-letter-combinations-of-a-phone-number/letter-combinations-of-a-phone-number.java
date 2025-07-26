class Solution {
    public List<String> letterCombinations(String digits) {
    ArrayList<String>res = new ArrayList<>();
    HashMap<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    rec(digits, 0, res , "", map);
    return res;

    }
    public void rec(String digits, int index, ArrayList<String>res, String curr, HashMap<Character,String> map){
        if(index==digits.length()){
            if(curr!=""){
                res.add(curr);
            
            }
            return;
        }
        String numAlpha = map.get(digits.charAt(index));
        for(int i=0;i<numAlpha.length();i++){
            curr+=numAlpha.charAt(i);
            rec(digits,index+1,res,curr,map);
            curr= curr.substring(0,curr.length()-1);
        }
    }
}