'''
It is a dynamic programming technique , using the LRU cache


Overview:
Time: (833ms) 79.74%
Memory: 45.8MB 6.28%
'''

from functools import lru_cache
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        max_columns, max_rows = len(mat[0]),len(mat)

        inf = max_columns + max_rows + 1

        @lru_cache(None)
        def down_right(row,column):
            if row == max_rows or column == max_columns:
                return inf
                
            res = min(min(down_right(row + 1, column),down_right(row,column+1))+1,mat[row][column])
            mat[row][column] = res
            return res
            
        @lru_cache(None)
        def up_left(row,column):
            if row < 0 or column < 0:
                return inf

            res = min(min(up_left(row-1,column),up_left(row,column-1))+1,mat[row][column])
            mat[row][column] = res
            return res
        
        for i in range(max_rows):
            for j in range(max_columns):
                if mat[i][j] == 1:
                    mat[i][j] = inf
        
        down_right(0,0)
        up_left(max_rows-1,max_columns-1)

        return mat
            

