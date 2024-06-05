def res(s:str)-> list[str]:
    res =[]


    if len(s) > 12:
        return res
        
    def backtrack(i,dots,curIP):
        if dots == 4 and i == len(s):
            res.append(curIP[:-1])
            return
        if dots > 4:
            print("dot is more than 4 so return-->")
            return
            
        for j in range(i,min(i+3,len(s))):
            if int(s[i:j+1]) < 255 and (i==j or s[i]!= "0"):
                print(curIP + s[i:j+1] + ".")
                backtrack(j+1,dots+1 ,curIP + s[i:j+1] + ".")
    backtrack(0,0,"")
    return res
    

print(res("25525511135"))