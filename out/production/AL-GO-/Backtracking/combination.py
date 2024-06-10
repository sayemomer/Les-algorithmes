def generate_combinations(nums):
    res = []
    
    def backtrack(start, path):
        # Append the current subset path to the result
        res.append(path.copy())
        
        # Start from the current element and explore deeper for each choice
        for i in range(start, len(nums)):
            # Include the number in the path
            path.append(nums[i])
            # Move on to the next element
            backtrack(i + 1, path)
            # Backtrack, remove the number and try the next possibility
            path.pop()

    backtrack(0, [])
    return res

# Given set
nums = [2, 3, 6]
# Generate all combinations
combinations = generate_combinations(nums)
# Print the combinations
for combo in combinations:
    print(combo)
