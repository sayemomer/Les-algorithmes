
# https://leetcode.com/problems/valid-parentheses/

class Solution:
    
    def is_match(self,p1, p2):
        
        if p1 == "(" and p2 == ")":
            return True
        elif p1 == "{" and p2 == "}":
            return True
        elif p1 == "[" and p2 == "]":
            return True
        else:
            return False
    
    def isValid(self, s: str) -> bool:
        paren_string = s
        stk = []
        is_balanced = True
        index = 0
        
        while index < len(paren_string) and is_balanced:
            paren = paren_string[index]
            if paren in "([{":
                 stk.append(paren)
            else:
                if stk == []:
                    is_balanced = False
                    break
                else:
                    top = stk.pop()
                    if not self.is_match(top, paren):
                        is_balanced = False
                        break
            index += 1
        if stk == [] and is_balanced:
            return True
        else:
            return False

      
ss = Solution()
# print(ss.isValid("()"))
print(ss.isValid("(((("))
# ss.isValid("()[]{}")
# ss.isValid("(]")
# ss.isValid("([)]")
# ss.isValid("{[]}")

