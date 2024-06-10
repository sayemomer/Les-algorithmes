from ctypes import pointer


class Solution:

    def shiftRight(self, nums, indexOfZero):
        temp = nums[indexOfZero-1]
        nums[indexOfZero - 1] = nums[indexOfZero]
        nums[indexOfZero] = temp

    def shiftLeft(self, nums, startIndex, endIndex):

        while endIndex != startIndex:
            temp = nums[endIndex-1]
            nums[endIndex-1] = nums[endIndex]
            nums[endIndex] = temp
            endIndex -= 1

    def merge(self, nums1, m, nums2, n) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

        firstPointer = 0
        secondPointer = 0
        indexOfZero = m

        # self.shiftLeft(nums1, firstPointer, indexOfZero)
        # # self.shiftLeft(nums1, firstPointer+1, indexOfZero+1)
        # print(nums1)

        if len(nums1) == 1:
            nums1[0] = nums2[0]
            return nums1
        elif n == 0:
            return nums1

        while firstPointer < len(nums1) and secondPointer < len(nums2):
            if nums1[firstPointer] == nums2[secondPointer]:
                self.shiftRight(nums1, indexOfZero)
                indexOfZero += 1
                nums1[firstPointer+1] = nums2[secondPointer]
                firstPointer += 1
                secondPointer += 1
            elif nums1[firstPointer] > nums2[secondPointer]:
                self.shiftLeft(nums1, firstPointer, indexOfZero)
                indexOfZero += 1
                nums1[firstPointer] = nums2[secondPointer]
                firstPointer += 1
                secondPointer += 1
            elif nums1[firstPointer] == 0:
                nums1[firstPointer] = nums2[secondPointer]
                indexOfZero += 1
                firstPointer += 1
                secondPointer += 1
            else:
                firstPointer += 1
        print(nums1)


ss = Solution()
# rs = ss.merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3)
# rs = ss.merge([1], 1, [], 0)
# rs = ss.merge([0], 0, [1], 1)
# rs = ss.merge([1, 2, 3, 0, 0, 0], 3, [2, 2, 2], 3)
# rs = ss.merge([1, 2, 3, 0, 0, 0], 3, [5, 5, 5], 3)
# rs = ss.merge([2, 2, 3, 0, 0, 0], 3, [1, 1, 1], 3)
# rs = ss.merge([2, 2, 3, 0, 0, 0], 3, [1, 2, 3], 3)
# rs = ss.merge([2, 0], 1, [1], 1)
rs = ss.merge([0, 0, 0, 0, 0], 0, [1, 2, 3, 4, 5], 5)
print(rs)
