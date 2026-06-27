class Solution:
    def reverseWords(self, s: str) -> str:
        # split() automatically handles multiple spaces and strips edges
        words = s.split()
        
        # Reverse the list of words
        words.reverse()
        
        # Join them back with a single space
        return " ".join(words)