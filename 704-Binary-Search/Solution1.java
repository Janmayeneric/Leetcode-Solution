/**
*   Overview:
*   Time: 0ms
*   Memory: 54.3MB(54.11%)
*
*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int u = nums.length - 1;
        while(l < u){
            int mid = (l + u + 1) / 2 ;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                u = mid -1;
            }else{
                return mid;
            }
        }
        if(l > u){
            return -1;
        }
        
        if(nums[l] == target){
            return l;
        }
        
        return -1;
    }
    
}