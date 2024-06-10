# 03/17/2022 13:01	Accepted	694 ms	27.4 MB	python3
# 25m52s24

class Solution:
    def containsNearbyDuplicate(self, nums, k) -> bool:
        hashTable = dict()

        for index in range(len(nums)):
            if nums[index] in hashTable:
                if abs(hashTable[nums[index]] - index) <= k:
                    return True
                else:
                    hashTable[nums[index]] = index
            else:
                hashTable[nums[index]] = index
        return False


ss = Solution()
rs = ss.containsNearbyDuplicate([1, 2, 3, 1, 2, 3], 2)
# rs = ss.containsNearbyDuplicate([1, 0, 1, 1], 1)
print(rs)
