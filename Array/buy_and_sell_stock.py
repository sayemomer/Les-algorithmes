from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
          profit=0
          for i in range(len(prices)):
            for j in range(i+1,len(prices)):
              if prices[j] > prices[i]:
                profit_money = prices[j] - prices[i]
                if profit_money > profit:
                  profit = profit_money
          return profit

ss = Solution()
rs = ss.maxProfit([7,1,5,3,6,4])
print(rs)