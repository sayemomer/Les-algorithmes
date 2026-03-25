import heapq
from typing import Counter, List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = Counter(nums)

        maxheap = [(-val,key) for key,val in count.items()]
        heapq.heapify(maxheap)

        nums = []
        for i in range(k):
            nums.append(heapq.heappop(maxheap)[1])

        return nums