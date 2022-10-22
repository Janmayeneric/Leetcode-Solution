'''
Hashmap approach:
72ms 72.71
14.5 67.9

'''
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hm = dict()
        for c in s:
            hm[c] = hm.get(c,0) + 1
        for c in t:
            counter = hm.get(c,0)
            if counter == 0:
                return False
            else:
                counter = counter - 1
                if counter == 0:
                    del hm[c]
                else:
                    hm[c] = counter
        if len(hm) > 0:
            return False
        return True
