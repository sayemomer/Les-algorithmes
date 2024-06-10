names = [('Ian','Botham'),('David','Gower'),('Ian','Bell'),('Ian','Chappell')]
names.sort()

def eliminate_duplicate(A):
    A.sort()
    write_index = 1
    for cand in A[1:]:
        if cand != A[write_index-1]:
            A[write_index] = cand
            write_index += 1
    print(A[0])


eliminate_duplicate(names)
