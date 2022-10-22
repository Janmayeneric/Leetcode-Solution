'''
My commen sense to do the palindrome

Time: 80ms 64.93%
Memory: 14.4MB 85.51%
'''
class Solution:
    def isPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s) - 1
        valids = set('qwertyuiopasdfghjklzxcvbnm0123456789')
        s = s.lower()

        while i < j:
            left = s[i]
            right = s[j]
            if left not in valids:
                i += 1
                continue
            if right not in valids:
                j -= 1
                continue
            if left != right:
                return False
            i += 1
            j -= 1
        return True
