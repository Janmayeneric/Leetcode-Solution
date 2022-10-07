'''
This is typical solution by greedy algorithm

Overview
Time: 823ms (85.6%)
Memory: 27.4MB (44.5%) 
'''
class Solution:
    def maxArea(self, height: List[int]) -> int:
        i = 0
        j = len(height) - 1
        max = 0
        while i < j:
            if height[i] > height[j]:
                area = height[j] * (j - i)
                j -= 1
            else:
                area = height[i] * (j - i)
                i += 1
            if area > max:
                max = area
        return max

