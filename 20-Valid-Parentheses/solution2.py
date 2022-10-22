'''
Very simple solution, but some detail are important

Time: 33ms 93%
Memory: 13.9MB 72.15%
'''
class Solution:
    def isValid(self, s: str) -> bool:
        right_p = {')':'(',']':'[','}':'{'}
        temp = []
        for c in s:
            if c in right_p:
                # important one a[b[]] is slower than a[] b[], there are some prioiry in it
                if not temp or right_p[c] != temp.pop():
                    return False
            else:
                temp.append(c)
        # list empty will return false
        return not temp
