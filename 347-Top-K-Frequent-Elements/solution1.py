'''
Put into the hashtable first
then using the binary search for sorting

Overview:
Time: 266ms (14.48%)
Space: 18.85MB (47.65%)
'''
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        d = {}

        for num in nums:
            d[num] = d.get(num, 0) + 1

        res = []
        for key in d.keys():
            size = len(res)
            if size < 2:
                if size == 0:
                    res.append([key, d[key]])
                    continue
                value = d[key]
                if value < res[0][1]:
                    res.insert(0, [key, value])
                else:
                    res.append([key, value])
                continue

            i = 0
            j = size - 1
            while True:
                if j - i == 1:
                    value = d[key]
                    if value < res[i][1]:
                        res.insert(i, [key, value])
                        break
                    if value > res[j][1]:
                        res.insert(j + 1, [key, value])
                        break
                    res.insert(j, [key, value])
                    break
                m = (i + j) // 2
                if d[key] > res[m][1]:
                    i = m
                else:
                    j = m

        ans = []
        while k > 0:
            ans.append(res.pop()[0])
            k -= 1
        return ans
