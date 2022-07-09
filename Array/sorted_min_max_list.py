from unittest import result


def max_min(lst):
    # Write your code here
    i = 0
    result = []
    firstPointer = []
    secondPointer = []
    while i < len(lst):
        if i % 2 == 0:
            firstPointer
            result.append(lst.pop())
        else:
            result.insert(0, lst.pop(0))
        i += 1
    return result


print(max_min([1, 2, 3, 4, 5]))
