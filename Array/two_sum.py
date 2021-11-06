# https://leetcode.com/problems/two-sum

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for j in range(len(nums)):
                for k in range(len(nums)):
                    t_sum = nums[j] + nums[k]
                    if t_sum == target:
                        if j != k:
                            return [j,k]
                
