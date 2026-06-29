class Solution:
    def increasingTriplet(self, nums: list[int]) -> bool:
        # Initialize the two smallest values found so far
        first = float('inf')
        second = float('inf')
        
        for n in nums:
            if n <= first:
                # n is the smallest value seen so far
                first = n
            elif n <= second:
                # n is larger than first, but smaller than or equal to second
                second = n
            else:
                # n is larger than both first and second, we found our triplet!
                return True
                
        return False