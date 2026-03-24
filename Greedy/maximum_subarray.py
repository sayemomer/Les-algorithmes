from typing import List


class Solution:


    def maxSubArray(self, nums: List[int]) -> int:

        max_arr = nums[0]
        
        curr = 0
        

        for num in nums:

            if curr < 0:
                curr = 0

            curr = curr + num
            max_arr = max(max_arr,curr)
        
        return max_arr






x = Solution()

x.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])