class Solution:

    def merge(self, nums1, m, nums2, n) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """

        firstPointer = m
        secondPointer = n
        writePointer = m + n - 1

        while firstPointer > 0 and secondPointer > 0:
            if nums1[firstPointer-1] > nums2[secondPointer-1]:
                nums1[writePointer] = nums1[firstPointer-1]
                firstPointer -= 1
            else:
                nums1[writePointer] = nums2[secondPointer-1]
                secondPointer -= 1
            writePointer -= 1

        while secondPointer > 0:
            nums1[writePointer] = nums2[secondPointer-1]
            writePointer -= 1
            secondPointer -= 1

        return nums1


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
