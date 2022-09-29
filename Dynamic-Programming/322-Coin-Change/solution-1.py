'''
Solution1, study some knowledge on the LRU cache

Performance

Time: 3249ms(31.11%)
Space: 34.4MB(13.33%)
'''
from functools import lru_cache
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        
        @lru_cache(None)
        def F(remain):
            if remain <= 0:
                if remain == 0:
                    return 0
                else:
                    return -1
            
            res_list = []
            
            for coin in coins:
                res =  F(remain - coin)
                if res != -1:
                    res_list.append( res +1)
            
            if len(res_list) == 0:
                return -1
            
            return min(res_list)
        
        return F(amount)
            
    
