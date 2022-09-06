/**
*   It is the second edition
*   However, it is still to slow
*   Maybe the reason of using HashMap?
*   Overview:
*
*   Time:32ms (29.19%)
*   Memory: 45.3MB(19.56%)
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 1;
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        char c = s.charAt(0);
        map.put(c,1);
        int major = 1;
        
        while(j < n){
            c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            // one important mistake i made
            // if right character is bigger or equal than current major character, replace it. no need for any record
            major = Math.max(major,map.get(c));
            
            if(major + k < j - i + 1){
                c = s.charAt(i);
                map.put(c,map.get(c)-1);
                ++i;
            }
            ++j;
        }
        return j - i;
    }
}