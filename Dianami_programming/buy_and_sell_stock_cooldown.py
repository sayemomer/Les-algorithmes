from typing import List


class Solution:



    def maxProfit(self, prices: List[int]) -> int:

        memo = {}

        def dfs(i, canBuy):
            if i >= len(prices):
                return 0
            
            if (i, canBuy) in memo:
                return memo[(i, canBuy)]

            if canBuy:
                buy = -prices[i] + dfs(i + 1, False)
                skip = dfs(i + 1, True)
                res = max(buy, skip)
            else:
                sell = prices[i] + dfs(i + 2, True)
                hold = dfs(i + 1, False)
                res =  max(sell, hold)
            
            memo[(i, canBuy)] = res
            return res

        return dfs(0, True)




x = Solution()
print(x.maxProfit([1]))