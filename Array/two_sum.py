# https://leetcode.com/problems/two-sum
# 32m19s01

# from ast import List


# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         ht = dict()
#         for i in range(len(nums)):
#             if nums[i] in ht:
#                 return [ht[nums[i]][0], i]
#             else:
#                 ht[target - nums[i]] = [i, nums[i]]
#         return False


def find_sum(lst, k):
    ht = dict()

    for i in lst:
        if i in ht:
            return [k-i, i]
        else:
            ht[k-i] = i


print(find_sum([1, 21, 3, 14, 5, 60, 7, 6], 81))
