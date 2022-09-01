class Solution {
    /**
    *   sliding windows technique to find the base palindromic substring
    *   construct the palindromic substring from small to possible largest
    *   Time: 24ms(88.99%)
    *   Space: 46.3MB(47.74%)
    */
    public String longestPalindrome(String s) {
        int temp_len = 1;
        
        // increase the speed, actually it really increase.....
        int s_len = s.length();
        String temp = Character.toString(s.charAt(0));
        for(int i = 0; i < s_len - 1; ++i){
            int j = i + 1;
            while(j <= i+2 && j < s_len){
                if(s.charAt(i) == s.charAt(j)){
                    int temp_i = i - 1;
                    int temp_j = j + 1;
                    
                    while(temp_i >= 0 && temp_j < s_len){
                        if(s.charAt(temp_i) == s.charAt(temp_j)){
                            -- temp_i;
                            ++ temp_j;
                        }else{
                            break;
                        }
                    }
                    int len = temp_j - temp_i - 1;
                    if(len > temp_len){
                        temp_len = len;
                        temp = s.substring(temp_i+1,temp_j);
                    }
                }
                ++j;
            }
        }
        return temp;
    }
}