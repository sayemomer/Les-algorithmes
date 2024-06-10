from ctypes import pointer
from itertools import count
from mimetypes import init
from operator import le
import re
from sys import int_info


class Solution:
    def countAndSay(self, n: int) -> str:

        init =["1","11"]
        if n<=2:
            return init[n-1]

        for j in range(2,n):
            initsq=init[j-1]
            res=''
            pointer=1
            i=0
            count=1
            while pointer<len(initsq):
                if initsq[i] == initsq[pointer]:
                    count+=1
                else:
                    res+= str(count) + str(initsq[i])
                    count=1
                    i=pointer
                if pointer == len(initsq)-1:
                    res+= str(count)+ str(initsq[i])
                pointer+=1
            init.append(res)

        return init

ss = Solution()
result = ss.countAndSay(30)
print(result)