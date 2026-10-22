class Solution {
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        // THERE IS A CONDITION WHEN OUR FUNCTION MIGHT RECIEVE VALUE LESS THAN 1 ..at n = 1 , n-1 = 0..
        ways[0] = 1;
        ways[1] = 1;
        if(n<2){
            
            return ways[n];
        }

        else{
            // bult the array...
            climbStairsUtil(ways) ;
        

        return ways[n];
    }
    }

    public void climbStairsUtil( int []ways){
        
        for(int i = 2; i < ways.length;i++){

        ways[i] = ways[i-1] + ways[i-2];
        
    }
   
}
}