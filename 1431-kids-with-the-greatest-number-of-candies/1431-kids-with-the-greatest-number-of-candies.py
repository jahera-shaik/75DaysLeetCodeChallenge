class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        # Find the maximum number of candies currently held by any kid
        max_candies = max(candies)
        
        # Return a list of booleans checking if each kid can reach or exceed the max
        return [candy + extraCandies >= max_candies for candy in candies]