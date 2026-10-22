class Solution {
    public int climbStairs(int n) {
        int ways[] = new int[2];
        // THERE IS A CONDITION WHEN OUR FUNCTION MIGHT RECIEVE VALUE LESS THAN 1 ..at n = 1 , n-1 = 0..
        ways[0] = 1;
        ways[1] = 1;
       
            // bult the array...
            climbStairsUtil(n,ways) ;
        

        return ways[1];
    
    }

    public void climbStairsUtil( int n,int []ways){
        
        for(int i = 1; i < n;i++){

        int temp  = ways[0] + ways[1];
            ways[0] = ways[1];
            ways[1] = temp;
            }
        
    }
   

}