class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        /**
        *   Overview
        *   Time: 8ms(81.44%)
        *   Memroy: 45.2MB(49.75%)
        */
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int lo = 0;
        int max = 0;        
        for(int i = 0 ; i < s.length(); i++){
            Character temp = s.charAt(i);
            if(map.containsKey(temp) && map.get(temp) >= lo){
                max = Math.max(max ,i-lo);
                lo = map.get(temp) + 1;
            }
            map.put(temp, i);
        }
        return Math.max(max,s.length() - lo);
    }
}