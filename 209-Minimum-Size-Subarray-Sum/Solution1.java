/**
* classic sliding windows problem
*
* overview:
* Time: 3ms(29.46%)
* Memory: 58MB(54.8%)
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int u = 0;
        int sum = 0;
        int res = 0;
        
        while(u < nums.length || sum >= target){
            if(sum < target){
                sum += nums[u++];
            }else{
                if(res == 0 || res > (u-l)){
                    res = u - l;
                }
                sum -= nums[l++];
            }
        }
            
        
        return res;
    }
}