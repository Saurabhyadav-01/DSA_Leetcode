class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
      // sorting of array...
      Arrays.sort(horizontalCut);
      Arrays.sort(verticalCut);
     

for (int i = 0, j = horizontalCut.length - 1; i < j; i++, j--) {
    int temp = horizontalCut[i];
    horizontalCut[i] = horizontalCut[j];
    horizontalCut[j] = temp;
}

for (int i = 0, j = verticalCut.length - 1; i < j; i++, j--) {
    int temp = verticalCut[i];
    verticalCut[i] = verticalCut[j];
    verticalCut[j] = temp;
}

 


       

        int hp = 1 ; 
        int vp = 1;
        int cost = 0;
        int h = 0; 
        int v = 0;

        while (h < horizontalCut.length && v < verticalCut.length) {
            if(verticalCut[v] <= horizontalCut[h]){
                cost = cost + ( vp* horizontalCut[h]);
                hp++; 
                // har cut ke saath ussi dimention ka ek oiece increase hoga..
                h++;
            }
            else{
                cost = cost + (hp* verticalCut[v]);
                vp ++;
                v++;
            }
                 
        }
// now resolve the issue of remaining h cut or v cuts alone

        while (h < horizontalCut.length) {
            cost += vp * horizontalCut[h];
                h++;
        }

        while (v < verticalCut.length) {
            cost += hp*verticalCut[v];
                v++;
        }
    return cost;
       
    }
    
}
