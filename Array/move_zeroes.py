from cProfile import run


class Solution:
    def moveZeroes(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        runningPointer = 0
        nonZeroPointer = 0

        # shift the non zero's in front

        while runningPointer < len(nums):
            if nums[runningPointer] != 0:
                nums[nonZeroPointer] = nums[runningPointer]
                nonZeroPointer += 1
                runningPointer += 1
            else:
                runningPointer += 1

        while nonZeroPointer < len(nums):
            nums[nonZeroPointer] = 0
            nonZeroPointer += 1

        return nums


ss = Solution()
rs = ss.moveZeroes([0, 1, 0, 3, 12])

print(rs)
