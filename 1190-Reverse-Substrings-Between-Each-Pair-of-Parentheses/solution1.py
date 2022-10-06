'''
This is a recursive method

Overview

Time: 47ms (72.78%)
Space: 13.8MB (97.15%)
'''

class Solution:
    def reverseParentheses(self, s: str) -> str:

        def recursive(i):
            res = []
            while True:
                c = s[i]
                if c == '(':
                    temp, i = recursive(i + 1)
                    res.extend(temp)
                    continue
                if c == ')':
                    res.reverse()
                    return res, i + 1
                res.append(c)
                i += 1

        i = 0
        res = []
        while i < len(s):
            c = s[i]
            if c == '(':
                temp, i = recursive(i + 1)
                res.extend(temp)
                continue
            res.append(c)
            i += 1
        return ''.join(res)