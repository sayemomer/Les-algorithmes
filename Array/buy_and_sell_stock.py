from typing import List


class Solution:

  # O(n^2) solution
    def maxProfit_one(self, prices: List[int]) -> int:
        profit = 0
        for i in range(len(prices)):
            for j in range(i+1, len(prices)):
                if prices[j] > prices[i]:
                    profit_money = prices[j] - prices[i]
                    if profit_money > profit:
                        profit = profit_money
        return profit

    # O(n) solution
    # 02/03/2022 13:00	Accepted	1112 ms	25.1 MB	python3
    def maxProfit_two(self, prices: List[int]) -> int:
        maxPf = 0
        minBuy = prices[0]

        for currentBuy in prices:
            maxPf = max((currentBuy-minBuy), maxPf)
            minBuy = min(currentBuy, minBuy)
        return maxPf


ss = Solution()
rs = ss.maxProfit_one([7, 1, 5, 3, 6, 4])
print(rs)
rs = ss.maxProfit_two([7, 6, 4, 3, 1])
print(rs)
