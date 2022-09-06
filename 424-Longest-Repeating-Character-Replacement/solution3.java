/**
*   wtf
*   this solution is really genuis
*   no more hashmap
*   this guys.......
*   
*   Overview:
*   Time: 9ms(67.38%)
*   Memory: 42.8Mb(75.58%)
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 1;
        int n = s.length();
        int[] arr = new int[26];
        
        char c = s.charAt(0);
        ++arr[c - 'A'];
        int major = 1;
        
        while(j < n){
            c = s.charAt(j);
            // this is really hard to understand
            // but it do fit the 26 letters......
            major = Math.max(major,++arr[c-'A']);
            
            if(major + k < j - i + 1){
                c = s.charAt(i);
                --arr[c-'A'];
                ++i;
            }
            ++j;
        }
        return j - i;
    }
}