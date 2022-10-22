'''
Easy code, but do the improvement
never stretch elemnt from array too many times in one round

Time: 1046ms 95.42%
Memory: 25.1MB 38.31%
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        j = 0
        left = prices[0]
        res = 0
        for p in prices:
            if p > left:
                res = max(res,p - left)
            else:
                left = p
        return res
