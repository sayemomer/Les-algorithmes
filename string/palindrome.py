def isPalindrome(s):

    rev = ''.join(reversed(s))

    if s == rev:
        return True
    else:
        return False

print(isPalindrome("geeks"))
print(isPalindrome("malayalam"))