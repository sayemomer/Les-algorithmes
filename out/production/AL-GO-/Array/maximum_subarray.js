// https://leetcode.com/problems/maximum-subarray/

var maxSubArray = function(nums) {

    var curr_index = 0
    var highest = nums[0]
  
    if(nums.length <=1 ){
      return nums[0]
    }

    while(curr_index < nums.length){
      var current_sum = nums[curr_index]

       if( current_sum > highest){
          highest = current_sum
        }

      // console.log(highest)

      for(i=curr_index;i<nums.length;i++){
        current_sum = current_sum + nums[i+1]

        if( current_sum > highest){
          highest = current_sum
        }
      }
      curr_index = curr_index + 1
    }

    if(nums[nums.length-1] > highest){
      return nums[nums.length-1]
    }

    return highest
    
};

// console.log(maxSubArray([1]))
// console.log(maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
// console.log(maxSubArray([5,4,-1,7,8]))
// console.log(maxSubArray([-2,-1]))
// console.log(maxSubArray([-2,1]))

console.log(maxSubArray([-1,0,-2]))