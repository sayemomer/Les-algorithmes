class GameEntry:
  
  def __init__(self,name,score):
    self.name = name
    self.score = score
  
  def get_name(self):
    return self.name
  
  def get_score(self):
    return self.score

  def __str__(self):
    return '({0},{1})'.format(self.name,self.score)

class Scoreboard:
 
  def __init__(self,capacity=10):
    self.board = [None] * capacity
    self.n = 0

  def get_item(self,k):
    return self.board[k]
  
  def __str__(self):
    return '\n'.join(str(self. board[j]) for j in range(self.n))

  def add(self,entry):
    score = entry.get_score()
    good = self.n < len(self.board) or score > self.board[-1].get_score()

    if good:
      if self.n < len(self. board):
        self.n += 1
        
      j = self.n - 1

      while j > 0 and self.board[j-1].get_score() < score:
        self. board[j] = self. board[j-1]
        j -= 1      
      self.board[j] = entry

if __name__ == '__main__':
  entry = GameEntry('liton',1)
  sb = Scoreboard(5)
  sb.add(entry)
  print(sb)
  
  # print(sb.__str__())

