# # https://leetcode.com/problems/maximum-subarray/

# def maxSubArray( nums: List[int]) -> int:
#         curr_index = 0
#         highest = nums[0]

#         if len(nums) <= 1:
#             return nums[0]

#         while curr_index < len(nums):
#             current_sum = nums[curr_index]

#             if current_sum > highest:
#                 highest = current_sum
#         #print(curr_index)
#             for x in range(curr_index,len(nums)-1):
#             #print(x)
#             #print(curr_index)
#             # print(x)
#                 current_sum = current_sum + nums[x+1]
#             #print(curr_index)
#             #print(highest)
#                 if current_sum > highest:
#                     highest = current_sum
#                 #print(highest)
#         curr_index = curr_index + 1

#         if nums[len(nums)-1] > highest:
#             return nums[len(nums) -1]

#         return highest


# # print(recursiveSum([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
# # print(recursiveSum([5,4,-1,7,8]))
# #print(recursiveSum([1]))
# # print(recursiveSum([-2,1]))
# # print(recursiveSum([-2,-1]))
# # print(recursiveSum([-1,0,-2]))

# list = [[[1, 2], [3, 4]], [[5, 6], [7, 8]]]


# def foo(m):
#     v = m[0][0]
#     print(v)
#     for row in m:
#         for element in row:
#             if v < element:
#                 v = element
#                 print(v)
#     return v


# # print(foo(list[0]))

# def f(i, values=[]):
#     values.append(i)
#     print(values)
#     return values


# f(1)
# f(2)
# f(3)
