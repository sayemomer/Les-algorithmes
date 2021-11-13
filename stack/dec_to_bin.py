from stack import Stack

def convert_int_to_bin(dec_num):
  binry = Stack()
  res = ''
  while dec_num >= 1:
    x = int((dec_num%2)//1)
    binry.push(x)
    dec_num = dec_num/2
  while not binry.is_empty():
    res = res + str(binry.pop())
  return res

print(convert_int_to_bin(242))
