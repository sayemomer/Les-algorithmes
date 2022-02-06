class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        s1 = s.replace(" ", "")
        s2 = t.replace(" ", "")
        ht = dict()

        if len(s1) != len(s2):
            return False

        for i in s1:
            if i in ht:
                ht[i] += 1
            else:
                ht[i] = 1
        for i in s2:
            if i in ht:
                ht[i] -= 1
            else:
                ht[i] = 1
        for i in ht:
            if ht[i] != 0:
                return False
        return True    
    

ss = Solution()
result = ss.isAnagram("anagram","nagaram")
result = ss.isAnagram("rat","car")
print(result)