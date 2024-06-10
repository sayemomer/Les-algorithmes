def binary_search(t,A):
    l,u = 0 , len(A) -1
    while l <=u:
        m = (l + u) // 2
        if A[m] == t :
            return A[m]
        elif A[m] < t :
            l = m + 1
        else:
            u = m -1
    return -1

print(binary_search(1,[1,2,3,4,5]))