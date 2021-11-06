def insertion_sort(nums):
  for k in range(1,len(nums)):
    cur = nums[k]
    j = k
    while j>0 and nums[j-1]>cur:
      nums[j] = nums[j-1]
      j -= 1
    nums[j] = cur
  return nums

print(insertion_sort([2,1,6,4,3]))
