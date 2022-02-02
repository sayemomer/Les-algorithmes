from typing import List
class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:

        max_nums =[]
        min_nums =[]

        if len(nums1) > len(nums2):
            max_nums = nums1
            min_nums = nums2
        else:
            max_nums = nums2
            min_nums = nums1

        intersec = []
        for i in range(len(min_nums)):
            for j in range(len(max_nums)):
                if min_nums[i] == max_nums[j]:
                    intersec.append(min_nums[i])
                    max_nums.pop(j)
                    break        
        return intersec

ss = Solution()
rs = ss.intersect([3,1,2],[1,1])
rs = ss.intersect([1,2,2,1],[2,2])
rs = ss.intersect([4,9,5],[9,4,9,8,4])
print(rs)

