class Solution:
    def sortedSquares(self, nums):
        firstPointer = 0
        secondPointer = len(nums) - 1
        result = []

        while secondPointer >= firstPointer:
            if abs(nums[firstPointer]) > abs(nums[secondPointer]):
                result = [nums[firstPointer] ** 2] + result
                firstPointer += 1
            else:
                result = [nums[secondPointer] ** 2] + result
                secondPointer -= 1
        return result


ss = Solution()
# rs = ss.sortedSquares([-4, -1, 0, 3, 10])
# rs = ss.sortedSquares([-7, -3, 2, 3, 11])
rs = ss.sortedSquares([-5, -3, -2, -1])
print(rs)
