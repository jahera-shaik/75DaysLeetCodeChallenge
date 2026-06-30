class Solution:
    def compress(self, chars: list[str]) -> int:
        write = 0
        read = 0
        
        while read < len(chars):
            char = chars[read]
            count = 0
            
            # Count the occurrences of the current character
            while read < len(chars) and chars[read] == char:
                read += 1
                count += 1
            
            # Write the character
            chars[write] = char
            write += 1
            
            # If count > 1, write the digits of the count
            if count > 1:
                for digit in str(count):
                    chars[write] = digit
                    write += 1
        
        return write