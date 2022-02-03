from typing import List
class Solution:

    def calculate_from_prev(self,prevNumber):
        numbers=[]
        for i in range(len(prevNumber)-1):
            numbers.append(prevNumber[i] + prevNumber[i+1])
        numbers.append(1)
        numbers.insert(0,1)
        return numbers
            

    def generate(self, numRows: int) -> List[List[int]]:
        
        result=[]
        for i in range(0,numRows):
            number = str(11 ** i)
            if i<=4:
                result.append([int(a) for a in number])
            else:
                result.append(self.calculate_from_prev(result[i-1]))
        return result


ss = Solution()
rs = ss.generate(30)
print(rs)