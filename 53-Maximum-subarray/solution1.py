'''
Some typical way of dynamic programming

Overview:
Time: 1106ms (64.85%)
Memory: 27.9MB (77.65%)
'''
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        current = nums[0]
        maximum = current
        i = 1
        length = len(nums)
        while i < length:
            next = nums[i]
            if current < 0:
                current = next
            else:
                current += next
            if current > maximum:
                maximum = current
            i += 1
        return maximum

