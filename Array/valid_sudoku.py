from re import sub
from typing import List
class Solution:

    def findSubBox(self,row,col):

        # row=2
        # col=7
        subBoxTop = [0,0]

        if row <=2:
            if col >= 6:
                subBoxTop=[0,6]
            elif col >= 3:
                subBoxTop=[0,3]
            else:
                subBoxTop=[0,0]
        elif row>=3 and row<6:
            if col >= 6:
                subBoxTop=[3,6]
            elif col >= 3:
                subBoxTop=[3,3]
            else:
                subBoxTop=[3,0]
        else:
            if col >= 6:
                subBoxTop=[6,6]
            elif col >= 3:
                subBoxTop=[6,3]
            else:
                subBoxTop=[6,0]
        return subBoxTop

                

        # subBoxTop=[[0,0],[0,3],[0,6],[3,0],[3,3],[3,6],[6,0],[6,3],[6,6]]



    def checkSubBox(self,board,row,col,target):

        subBoxTop=self.findSubBox(row,col)

        print(subBoxTop)

        counter=0
        for i in range(subBoxTop[0],(subBoxTop[0]+3)):
            for j in range(subBoxTop[1],(subBoxTop[1]+3)):
                if board[i][j] == target:
                    counter+=1
        if counter>1:
            return False
        else:
            return True


    def checkColumn(self,board,col,target):
        counter=0
        for i in range(len(board[0])):
            if board[i][col] == target:
                counter+=1
        if counter>1:
            return False
        else:
            return True


    def checkRow(self,board,row,target):
        counter=0
        for i in range(len(board[row])):
            if board[row][i] == target:
                counter+=1
        if counter>1:
            return False
        else:
            return True
    
    def checkValid(self,board,row,col,target):

        rowchk = self.checkRow(board,row,target)
        colchk = self.checkColumn(board,col,target)
        subBoxchk = self.checkSubBox(board,row,col,target)

        if rowchk == False or colchk== False or subBoxchk==False:
            return False
        else:
            return True



    def isValidSudoku(self, board: List[List[str]]) -> bool:

        for i in range(9):
            for j in range(9):
                if board[i][j] != ".":
                    print(board[i][j])
                    if self.checkValid(board,i,j,board[i][j])==False:
                        return False

ss = Solution()
rs = ss.isValidSudoku([["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]])
print(rs)