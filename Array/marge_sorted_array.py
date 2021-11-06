# https://leetcode.com/problems/merge-sorted-array/

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        joined_list = nums1[slice(0,m)] + nums2[slice(0,n)]
        # nums1 = self.selection_sort(joined_list)
        nums1 = joined_list.sort()
        return 
    
    def findSmallest(self,arr):
        smallest = arr[0]
        smallest_index = 0
        for i in range(1,len(arr)):
            if arr[i] < smallest:
                smallest = arr[i]
                smallest_index = i
        return smallest_index

    def selection_sort(self,arr):
        newArr = []
        for i in range(len(arr)):
            smallest = self.findSmallest(arr)
            newArr.append(arr.pop(smallest))
        return newArr
        
        
        
