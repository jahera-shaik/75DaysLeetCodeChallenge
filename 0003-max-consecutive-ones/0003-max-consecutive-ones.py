class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        count=0
        best=0
        for x in nums:
            if x==1:
                count=count+1
                if count>best:
                    best=count
                
            else:
                count=0
        return best
            
        