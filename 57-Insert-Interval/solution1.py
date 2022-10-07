'''
Idea is quite easy, but the corner case is extremely disgusting

Overview:
Time 155ms(47.8)
Memory 17.3MB(91.65)
'''
class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []

        isMerging = True

        left = newInterval[0]
        right = newInterval[1]

        for interval in intervals:
            interval_left = interval[0]
            interval_right = interval[1]
            if isMerging:
                if interval_right < left:
                    res.append(interval)
                elif interval_left > right:
                    res.append([left, right])
                    res.append(interval)
                    isMerging = False
                else:
                    left = min(interval_left, left)
                    right = max(interval_right, right)
            else:
                res.append(interval)
        if isMerging is True:
            res.append([left, right])
        return res