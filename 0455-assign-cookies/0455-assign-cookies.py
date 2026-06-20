class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g=sorted(g)
        s=sorted(s)
        child=0
        for cookie in s:
            if child<len(g) and cookie >=g[child]:
                child=child+1
        return child

        