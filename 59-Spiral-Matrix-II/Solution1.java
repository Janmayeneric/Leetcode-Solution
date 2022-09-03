/**
*   Overview:
*   Time:0ms
*   Memory: 42.5%(16.25%)
*   
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int r = 0;
        int c = 0;
        int counter = 1;
        int[][] res = new int[n][n];
        while(n > 1){
            for(int i = 0 ; i < n - 1; i ++){
                res[r][c++] = counter ++;
            }
            for(int i = 0 ; i < n - 1; i ++){
                res[r++][c] = counter ++;
            }
            for(int i = 0 ; i < n - 1; i ++){
                res[r][c--] = counter ++;
            }
            for(int i = 0 ; i < n - 1; i ++){
                res[r--][c] = counter ++;
            }
            ++r;
            ++c;
            n -= 2;
        }
        if(n == 1){
            res[r][c] = counter;
        }
        
        return res;
    }
}