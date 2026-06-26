class Solution:
    def reverseVowels(self, s: str) -> str:
        # Convert string to list for mutability
        chars = list(s)
        left, right = 0, len(chars) - 1
        # Set of vowels for O(1) lookup speed
        vowels = set("aeiouAEIOU")
        
        while left < right:
            # Move left pointer until we find a vowel
            if chars[left] not in vowels:
                left += 1
            # Move right pointer until we find a vowel
            elif chars[right] not in vowels:
                right -= 1
            # Both pointers are at vowels, perform the swap
            else:
                chars[left], chars[right] = chars[right], chars[left]
                left += 1
                right -= 1
                
        return "".join(chars)