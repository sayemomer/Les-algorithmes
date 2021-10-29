# https://leetcode.com/problems/maximum-subarray/

def maxSubArray( nums: List[int]) -> int:
        curr_index = 0
        highest = nums[0]

        if len(nums) <= 1:
            return nums[0]

        while curr_index < len(nums):
            current_sum = nums[curr_index]

            if current_sum > highest:
                highest = current_sum
        #print(curr_index)
            for x in range(curr_index,len(nums)-1):
            #print(x)
            #print(curr_index)
            # print(x)
                current_sum = current_sum + nums[x+1]
            #print(curr_index)
            #print(highest)
                if current_sum > highest:
                    highest = current_sum
                #print(highest)
        curr_index = curr_index + 1

        if nums[len(nums)-1] > highest:
            return nums[len(nums) -1]

        return highest


# print(recursiveSum([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
# print(recursiveSum([5,4,-1,7,8]))
#print(recursiveSum([1]))
# print(recursiveSum([-2,1]))
# print(recursiveSum([-2,-1]))
# print(recursiveSum([-1,0,-2]))