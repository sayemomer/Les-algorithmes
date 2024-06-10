class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:

        ht=dict()

        for i in ransomNote:
            if i in ht:
                ht[i]+=1
            else:
                ht[i]=1
        
        for j in magazine:
            if j in ht:
                ht[j]-=1
        
        for k in ht:
            if ht[k] > 0:
                return False
        return True
        
ss = Solution()
result = ss.canConstruct("a","b")
result = ss.canConstruct("aa","ab")
result = ss.canConstruct("aa","aab")
result = ss.canConstruct("omer sayem","omer sayem")
print(result)