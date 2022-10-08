'''
Extremely simple way to do from the others' solution

However, the speed is low


Time: 1685ms 41.35%
Memory: 20.2MB 81%
'''

import heapq
import math

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        return heapq.nsmallest(k,points,lambda x:x[0]*x[0] + x[1]*x[1])
