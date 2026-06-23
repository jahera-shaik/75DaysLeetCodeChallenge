import math

class Solution:
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        # Check if they share any common base
        if str1 + str2 != str2 + str1:
            return ""
        
        # Find the GCD of the lengths
        gcd_length = math.gcd(len(str1), len(str2))
        
        # The result is the prefix of length gcd_length
        return str1[:gcd_length]