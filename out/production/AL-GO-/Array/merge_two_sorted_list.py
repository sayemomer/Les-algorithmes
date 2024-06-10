# 29m21s75

# one
# def merge_lists(lst1, lst2):
#     # Write your code here
#     firstPointer = 0
#     secondPointer = 0
#     sorted_lst = []

#     while firstPointer < len(lst1) and secondPointer < len(lst2):
#         if lst1[firstPointer] < lst2[secondPointer]:
#             sorted_lst.append(lst1[firstPointer])
#             firstPointer += 1
#         elif lst1[firstPointer] > lst2[secondPointer]:
#             sorted_lst.append(lst2[secondPointer])
#             secondPointer += 1
#         else:
#             sorted_lst.append(lst1[firstPointer])
#             sorted_lst.append(lst2[secondPointer])
#             firstPointer += 1
#             secondPointer += 1

#     if firstPointer < len(lst1):
#         for i in lst1[firstPointer:]:
#             sorted_lst.append(i)
#     if secondPointer < len(lst2):
#         for i in lst2[secondPointer:]:
#             sorted_lst.append(i)

#     print(sorted_lst)


# # two

# # merge_lists([1, 3, 4, 5], [2, 6, 7, 8])
# # merge_lists([1, 3, 4, 5], [1, 6, 7, 8])
# merge_lists([-1, 3, 4, 5], [1, 6, 7, 8])


def merge_lists(lst1, lst2):
    # Write your code here
    firstIndexPointer = 0
    secondIndexPointer = 0
    sorted_lst = []

    while firstIndexPointer < len(lst1) and secondIndexPointer < len(lst2):
        if lst1[firstIndexPointer] < lst2[secondIndexPointer]:
            sorted_lst.append(lst1[firstIndexPointer])
            firstIndexPointer += 1
        else:
            sorted_lst.append(lst2[secondIndexPointer])
            secondIndexPointer += 1

    if firstIndexPointer < len(lst1):
        for i in lst1[firstIndexPointer:]:
            sorted_lst.append(i)
    if secondIndexPointer < len(lst2):
        for i in lst2[secondIndexPointer:]:
            sorted_lst.append(i)

    print(sorted_lst)


# merge_lists([1, 3, 4, 5], [2, 6, 7, 8])
# merge_lists([1, 3, 4, 5], [1, 6, 7, 8])
merge_lists([-1, 3, 4, 5], [1, 6, 7, 8])
