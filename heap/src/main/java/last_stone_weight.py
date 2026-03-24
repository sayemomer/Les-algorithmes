from typing import List
import heapq


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:

        maxheap = [ -st for st in stones]
        heapq.heapify(maxheap)

        while len(maxheap) > 1:
            first_stone = heapq.heappop(maxheap)
            second_stone = heapq.heappop(maxheap)

            if first_stone  != second_stone:
                heapq.heappush(maxheap,first_stone - (second_stone))

        return - maxheap[0] if maxheap else 0



x = Solution()
x.lastStoneWeight([1,1])
