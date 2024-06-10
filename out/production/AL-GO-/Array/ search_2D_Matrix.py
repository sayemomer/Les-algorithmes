from traceback import print_tb
from typing import List
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:

        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] == target:
                    return True
        return False



ss = Solution()
rs = ss.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],13)
rs = ss.searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]],3)
rs = ss.searchMatrix([[1]],1)
print(rs)