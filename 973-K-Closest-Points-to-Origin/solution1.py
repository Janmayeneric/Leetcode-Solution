'''

Heap way to do the K sorting, heap is good for maintaing the K length array


Time: 1227 ms 64.54%
Memory: 21MB 5.52%
'''

import heapq
import math

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        num = 0
        heap = []
        hm = {}
        dis_set = set()

        for p in points:

            dis = -math.sqrt(p[0] ** 2 + p[1] ** 2)

            if num == k:
                if dis <= heap[0]:
                    continue
                del_dis = heapq.heappop(heap)
                num -= len(hm[del_dis])
                del hm[del_dis]
                dis_set.remove(del_dis)

            list_ps = hm.get(dis,[])
            list_ps.append(p)
            hm[dis] = list_ps
            dis_set.add(dis)
            heapq.heappush(heap,dis)
            num += 1
        
        res = []
        for key in hm.keys():
            for p in hm[key]:
                res.append(p)
        
        return res
