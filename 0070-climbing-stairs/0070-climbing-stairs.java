class Solution {
    public int climbStairs(int n) {
        
        // THERE IS A CONDITION WHEN OUR FUNCTION MIGHT RECIEVE VALUE LESS THAN 1 ..at n = 1 , n-1 = 0..
        int prev1 = 1;
        int prev2 = 1;
       
    for(int i = 1; i < n;i++){

            int temp  = prev1 + prev2;
            prev1 = prev2;
            prev2 = temp;
            
        }  
        

        return prev2;
    
    }

    
   

}