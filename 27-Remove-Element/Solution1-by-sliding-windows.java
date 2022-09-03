/**
* Sliding windows solution
*
*
*   Overview
* Time: 0ms
* Memory 43.1MB(11.87%)
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int p = 0;
        
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != val){
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}