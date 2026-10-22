class Solution {
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        // THERE IS A CONDITION WHEN OUR FUNCTION MIGHT RECIEVE VALUE LESS THAN 1 ..at n = 1 , n-1 = 0..
        
 
        return climbStairsUtil(n,ways) ;
    }

    public int climbStairsUtil(int n, int []ways){
        if(n == 0 || n ==1){
            return 1;
        }
        if(ways[n] != 0){
            return ways[n];
        }

        ways[n] = climbStairsUtil(n-1,ways) + climbStairsUtil(n-2, ways);
        return ways[n];
    }
}