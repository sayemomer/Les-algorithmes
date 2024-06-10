class Solution:
    def removeElement(self, nums, val) -> int:
        runningPointer, nonValPointer = 0, 0

        while runningPointer < len(nums):
            if nums[runningPointer] == val:
                runningPointer += 1
            else:
                nums[nonValPointer] = nums[runningPointer]
                runningPointer += 1
                nonValPointer += 1

        while nonValPointer < len(nums):
            del nums[nonValPointer]
            nonValPointer += 1

        return nums


ss = Solution()
rs = ss.removeElement([3, 2, 2, 3], 3)

print(rs)
