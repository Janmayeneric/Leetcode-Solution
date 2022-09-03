/**
*      use the idea of Monotonic stack 
*      two stack, one for get next greatest element and vice versa for the next one
*      
*       Overview:
*       Runtime: 25ms(68.21%)
*       Memory: 46.3MB(27.23%)
*/
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] nextGreaterElement = new int[n];
        int[] lastSmallerElement = new int[n];
        int[] products = new int[n];
        
        Stack<Integer> largestTop = new Stack<Integer>();
        Stack<Integer> smallestTop = new Stack<Integer>();
        
        
        for(int i=n-1;i>=0;i--){
            while(!largestTop.empty() && nums[i] >= nums[largestTop.peek()]){
                largestTop.pop();
                
            }
            nextGreaterElement[i] = largestTop.empty() ? n : largestTop.peek();
            largestTop.push(i);
            while(!smallestTop.empty() && nums[i] <= nums[smallestTop.peek()]){
                smallestTop.pop();
            }
            lastSmallerElement[i] = smallestTop.empty()? n: smallestTop.peek();
            smallestTop.push(i);
        }
        
        
        
        for(int i = 0 ; i < n - 1; i ++){
            int j = i;
            products[j] += n - 1 - j;
            int prev = j;
            j = nextGreaterElement[j];
            while(j < n){
                products[prev] -= n - j;
                products[j] += n - j;
                prev = j;
                j = nextGreaterElement[j];
            }
            
            j = i;
            products[j] -= n - 1 - j;
            prev = j;
            j = lastSmallerElement[j];
            while(j < n){
                products[prev] += n - j;
                products[j] -= n - j;
                prev = j;
                j = lastSmallerElement[j];
            }
            
        }
        long res = 0;
        
        
        for(int i = 0; i < n; i++){
            
            
            // this one is important for the long result
            res += (long)products[i] * (long)nums[i];
        }
        
        return res;
    }
}