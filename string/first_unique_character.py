class Solution:
    def firstUniqChar(self, s: str) -> int:

        uniqueIndex=dict()
        for i in range(len(s)):
            if s[i] not in uniqueIndex:
                uniqueIndex[s[i]]=[i,1]
            else:
                uniqueIndex[s[i]][1]+=1
        print(uniqueIndex)

        for i in uniqueIndex:
            # print(uniqueIndex[i][0])
            if uniqueIndex[i][1] == 1:
                return uniqueIndex[i][0]
        return -1


        
ss = Solution()
result = ss.firstUniqChar("leetcode")
# result = ss.firstUniqChar("aabb")
# result = ss.firstUniqChar("loveleetcode")
# result = ss.firstUniqChar("aadadaad")

print(result)