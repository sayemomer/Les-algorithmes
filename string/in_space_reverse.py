# https://leetcode.com/problems/reverse-string/
class Solution:

    def swapString(self, s, first, second):
        temp = s[first]
        s[first] = s[second]
        s[second] = temp

    def reverseString(self, s) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        for i in range(int(len(s)/2)):
            self.swapString(s, i, len(s)-i-1)


ss = Solution()
result = ss.reverseString(["h", "e", "l", "l", "o"])
print(result)
