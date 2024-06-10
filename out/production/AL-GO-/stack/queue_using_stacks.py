class MyQueue:

    def __init__(self):
        self.que = []
        

    def push(self, x: int) -> None:
        self.que.append(x)
        

    def pop(self) -> int:
        x = self.que.pop(0)
        return x
        

    def peek(self) -> int:
        x = self.que[0]
        return x
        

    def empty(self) -> bool:
        if len(self.que) == 0:
            return True
        else:
            return False
        


#Your MyQueue object will be instantiated and called as such:
obj = MyQueue()
obj.push(1)
obj.push(2)
param_2 = obj.pop()
param_3 = obj.peek()
param_4 = obj.empty()

print(param_2,param_3,param_4)