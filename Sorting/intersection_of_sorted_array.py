array1 = [2,3,3,5,5,6,7,7,8,12]
array2 = [5,5,6,8,8,9,10,10]

# brute force solution
merged_array = array1 + array2

common_array = []

for i in merged_array:
    if i not in common_array:
        common_array.append(i)    

print(common_array)