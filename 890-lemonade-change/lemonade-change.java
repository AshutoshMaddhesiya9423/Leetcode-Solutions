class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int count_1=0;
        int count_2=0;
      
        for(int bill:bills){
            if(bill==5){
                count_1++;
            }
            else if(bill==10){
                if(count_1>0){
                    count_1--;
                    count_2++;
                }
                else{
                return false;}
                
            }
            else{
                if(count_2>0&&count_1>0){
                    count_2--;
                    count_1--;
                }
                else if(count_1>2){
                 count_1= count_1-3;
                 
                }
                else{
                return false;}
            }
        }
        return true;
    }
}