# 03/16/2022 18:29	Accepted	144 ms	14 MB	python3

import collections


class Solution:

    def findSubBox(self, row, col):

        # row=2
        # col=7
        subBoxTop = [0, 0]

        if row <= 2:
            if col >= 6:
                subBoxTop = [0, 6]
            elif col >= 3:
                subBoxTop = [0, 3]
            else:
                subBoxTop = [0, 0]
        elif row >= 3 and row < 6:
            if col >= 6:
                subBoxTop = [3, 6]
            elif col >= 3:
                subBoxTop = [3, 3]
            else:
                subBoxTop = [3, 0]
        else:
            if col >= 6:
                subBoxTop = [6, 6]
            elif col >= 3:
                subBoxTop = [6, 3]
            else:
                subBoxTop = [6, 0]
        return subBoxTop

        # subBoxTop=[[0,0],[0,3],[0,6],[3,0],[3,3],[3,6],[6,0],[6,3],[6,6]]

    def checkSubBox(self, board, row, col, target):

        subBoxTop = self.findSubBox(row, col)

        print(subBoxTop)

        counter = 0
        for i in range(subBoxTop[0], (subBoxTop[0]+3)):
            for j in range(subBoxTop[1], (subBoxTop[1]+3)):
                if board[i][j] == target:
                    counter += 1
        if counter > 1:
            return False
        else:
            return True

    def checkColumn(self, col, target, colHashMap):
        if target in colHashMap[col]:
            return False
        else:
            colHashMap[col].add(target)
            return True

    def checkRow(self, row, target, rowHashTable):
        if target in rowHashTable[row]:
            return False
        else:
            rowHashTable[row].add(target)
            return True

    def checkValid(self, board, row, col, target, rowHashMap, colHashMap):

        rowchk = self.checkRow(row, target, rowHashMap)
        colchk = self.checkColumn(col, target, colHashMap)
        subBoxchk = self.checkSubBox(board, row, col, target)

        if rowchk == False or colchk == False or subBoxchk == False:
            return False
        else:
            return True

    def isValidSudoku(self, board) -> bool:

        rowHashMap = collections.defaultdict(set)
        colHashMap = collections.defaultdict(set)

        for row in range(9):
            for col in range(9):
                if board[row][col] != ".":
                    if self.checkValid(board, row, col, board[row][col], rowHashMap, colHashMap) == False:
                        return False
        return True


ss = Solution()
rs = ss.isValidSudoku([["8", "3", ".", ".", "7", ".", ".", ".", "."], ["6", ".", ".", "1", "9", "5", ".", ".", "."], [".", "9", "8", ".", ".", ".", ".", "6", "."], ["8", ".", ".", ".", "6", ".", ".", ".", "3"], [
                      "4", ".", ".", "8", ".", "3", ".", ".", "1"], ["7", ".", ".", ".", "2", ".", ".", ".", "6"], [".", "6", ".", ".", ".", ".", "2", "8", "."], [".", ".", ".", "4", "1", "9", ".", ".", "5"], [".", ".", ".", ".", "8", ".", ".", "7", "9"]])
print(rs)
