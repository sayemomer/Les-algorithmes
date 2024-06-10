# https://leetcode.com/problems/reverse-string/
class Solution:

    def reverseString(self, s) -> None:
        """
        Do not return anything, modify s in-place instead.
        """

        return [s[len(s)-1-i] for i in range(len(s))]

    def reversePlainString(self, s):
        print(''.join(reversed(s)))


ss = Solution()
result = ss.reverseString(["h", "e", "l", "l", "o"])
result = ss.reversePlainString("hello")
print(result)
