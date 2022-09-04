class Solution {
    /**
    *   sliding window problem , but why so slow
    *   
    *   OverView:
    *   Time 135ms (6.69%)
    %   Memory 55.6MB(5.04%)
    */
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> char_map = new HashMap<Character,Integer>();
        HashMap<Integer,HashSet<Character>> num_map = new HashMap<Integer,HashSet<Character>>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int res = 1;
        num_map.put(1,new HashSet<Character>());
        
        while( j < n ){
            char c = s.charAt(j);
            if(char_map.containsKey(c)){
                int prev = char_map.get(c);
                int current = prev + 1;
                HashSet<Character> c_set = num_map.get(prev);
                c_set = c_set == null?new HashSet<Character>():c_set;
                c_set.remove(c);
                num_map.put(current,c_set);
                if(!num_map.containsKey(current)){
                    c_set = new HashSet<Character>();
                    c_set.add(c);
                    num_map.put(current,c_set);
                }else{
                    c_set = num_map.get(current);
                    c_set.add(c);
                    num_map.put(current,c_set);
                }
                char_map.put(c,char_map.get(c) + 1);
            }else{
                char_map.put(c,1);
                HashSet<Character> c_set = num_map.get(1);
                c_set = c_set == null?new HashSet<Character>():c_set;
                c_set.add(c);
                num_map.put(1,c_set);
            }
            //System.out.println(i + "||" +j);
            int longestSub = num_map.size();
            //System.out.println(longestSub);
            if((j - i + 1) - longestSub > k){
                c = s.charAt(i);
                int prev = char_map.get(c);
                int current = prev - 1;
                if(current == 0) char_map.remove(c);
                    else char_map.put(c,current);
                char_map.put(c,prev - 1);
                HashSet<Character> c_set = num_map.get(prev);
                c_set.remove(c);
                if(c_set.size() == 0) num_map.remove(prev);
                if(current > 0){
                    c_set = num_map.get(current);
                    c_set.add(c);
                    num_map.put(current,c_set);
                }
                ++i;
            }else{
                res = j - i + 1;
            }
            ++j;
            
            
        }
        return res;
    }
}