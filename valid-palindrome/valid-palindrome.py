class Solution:
    def isPalindrome(self, s: str) -> bool:
        inputStr = ""
        for ch in s.lower():
            if ch.isalnum():
                inputStr += ch
        
        return inputStr == inputStr[::-1]
        