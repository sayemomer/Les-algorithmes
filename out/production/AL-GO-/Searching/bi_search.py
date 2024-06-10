def search(nums, target):
        start_index = 0
        end_index = len(nums) - 1
        
        # print(len(nums))
        
        if len(nums) == 1 and nums[0] == target:
            return 0
        
        while start_index <= end_index:
            mid = int((start_index + end_index)/2)
            # print(mid)
            guess = nums[mid]
            if guess == target:
                return mid
            if guess < target:
                start_index = mid + 1 
            else:
                end_index = mid - 1
        return -1

print(search([2,5],5))
# print(search([0],0))
# print(search([-1,0,3,5,9,12],9))
