# 03/17/2022 12:14	Accepted	1343 ms	14.1 MB	python3
# 19m21s62

import collections


class Solution:
    def checkValid(self, matrix) -> bool:
        rowHashMap = collections.defaultdict(set)
        colHashMap = collections.defaultdict(set)

        for row in range(len(matrix)):
            for col in range(len(matrix)):
                if matrix[row][col] in rowHashMap[row] or matrix[row][col] in colHashMap[col]:
                    return False
                else:
                    rowHashMap[row].add(matrix[row][col])
                    colHashMap[col].add(matrix[row][col])
        return True


ss = Solution()
# rs = ss.checkValid([[1, 2, 3], [3, 1, 2], [2, 3, 1]])
rs = ss.checkValid([[1, 1, 1], [1, 2, 3], [1, 2, 3]])
print(rs)
