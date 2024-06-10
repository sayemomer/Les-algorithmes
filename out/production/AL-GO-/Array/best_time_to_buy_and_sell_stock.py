# 03/17/2022 17:54	Accepted	2082 ms	25.1 MB	python3
# 1h33m32s42

from cmath import inf


class Solution:
    def maxProfit(self, prices) -> int:
        profit = float('-inf')
        buyingPrice = float('inf')
        sellingPrice = float('-inf')

        for currentPrice in prices:
            if currentPrice < buyingPrice:
                buyingPrice = currentPrice
                sellingPrice = buyingPrice
            else:
                buyingPrice = min(buyingPrice, currentPrice)
                sellingPrice = max(sellingPrice, currentPrice)
            profit = max((sellingPrice - buyingPrice), profit)

        return profit


ss = Solution()
# rs = ss.maxProfit([7, 1, 5, 3, 6, 4])
rs = ss.maxProfit([7, 6, 4, 3, 1])
print(rs)
