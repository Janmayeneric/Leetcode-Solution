class Solution {
    public int reverse(int x) {
        /**
        * String operation
        * ------------------Overview 
        * Time: 3ms(29.14%)
        * Memory: 41.6MB 34.19%
        */
        final String INT32NEG = "2147483648";
        final String INT32POS = "2147483647";
        final int LIMIT_DIGIT = 10;
        
        String str_x = String.valueOf(x);
        int num_zeros = 0;
        for(int i = str_x.length(); i < -1; i--){
            if(str_x.charAt(i) == '0'){
                ++num_zeros;
            }else{
                break;
            }
        }
        
        
        int start = str_x.charAt(0) == '-'? 1 : 0;
        int end = str_x.length() - 1 - num_zeros;
        if(start == end){
            if(start == 0){
                return Character.getNumericValue(str_x.charAt(start));
            }else{
                return 0;
            }
        }
        
        if(end == -1){
            return 0;
        }
        
        if((end - start + 1) > LIMIT_DIGIT){
            return 0;
        }
        
        StringBuilder sb = new StringBuilder();
        if((end - start + 1) == LIMIT_DIGIT){
            
            int c = 0;
            String str32 = start == 0 ? INT32POS: INT32NEG;
            boolean checked = false;
            for(int i = end; i >= start; i--){
                char ch = str_x.charAt(i);
                char ch32 = str32.charAt(c++);
                if(ch32 != ch && !checked){
                    if(ch32 < ch){
                        return 0;
                    }else{
                        checked = true;
                    }
                }
                sb.append(ch);
            }
            return (start == 0 ? 1 : -1)
                    *Integer.parseInt(sb.toString());
        }
        
        for(int i = end; i >= start; --i){
            sb.append(str_x.charAt(i));
        }
        
        return (start == 0 ? 1 : -1)
                    *Integer.parseInt(sb.toString());
        
        
    }
}