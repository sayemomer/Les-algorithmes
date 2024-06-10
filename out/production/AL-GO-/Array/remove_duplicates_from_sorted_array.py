# 03/29/2022 18:00	Accepted	92 ms	15.6 MB

class Solution:
    def removeDuplicates(self, nums) -> int:
        uniqueSet = sorted(list(set(nums)))

        runningPointer = 0
        nonUniquePointer = 0

        while runningPointer < len(nums):
            if nonUniquePointer < len(uniqueSet):
                nums[nonUniquePointer] = uniqueSet[nonUniquePointer]
                nonUniquePointer += 1
                runningPointer += 1
            else:
                nums[runningPointer] = '_'
                runningPointer += 1

        return nonUniquePointer


ss = Solution()
# rs = ss.removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4])
rs = ss.removeDuplicates([-1, 0, 0, 0, 0, 3, 3])
print(rs)
