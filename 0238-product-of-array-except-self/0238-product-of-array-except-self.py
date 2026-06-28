class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        n = len(nums)
        # Initialize result array with 1s
        res = [1] * n
        
        # Calculate prefix products:
        # res[i] will contain the product of all elements to the left of i
        prefix = 1
        for i in range(n):
            res[i] = prefix
            prefix *= nums[i]
            
        # Calculate suffix products and multiply with existing prefix products:
        # res[i] will become (product of left) * (product of right)
        suffix = 1
        for i in range(n - 1, -1, -1):
            res[i] *= suffix
            suffix *= nums[i]
            
        return res