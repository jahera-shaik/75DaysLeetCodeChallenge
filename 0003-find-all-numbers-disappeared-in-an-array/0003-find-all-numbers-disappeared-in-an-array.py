class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        n = len(nums)
        counts = {}
        for x in nums:                    # LOOP 1: build the tally — finishes completely
            counts[x] = counts.get(x, 0) + 1

        result = []
        for i in range(1, n + 1):         # LOOP 2: separate, lined up under LOOP 1
            if counts.get(i, 0) == 0:     # i never showed up → it's missing
                result.append(i)          # collect it
        return result