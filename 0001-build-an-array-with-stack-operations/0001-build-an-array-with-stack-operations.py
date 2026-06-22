class Solution:
    def buildArray(self, target: List[int], n: int) -> List[str]:
        target_set=set(target)
        result=[]
        for num in range(1,target[-1]+1):
            result.append("Push")
            if num not in target_set:
                result.append("Pop")
        return result