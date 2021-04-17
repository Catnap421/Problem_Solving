class Solution:
    def longestPalindrome(self, s: str) -> str:
        for i in range(len(s), 0, -1):
            for j in range(len(s) + 1 - i): 
                if self.isPalindrome(s[j: j+i]):
                    return s[j:j + i]
        
        
    def isPalindrome(self, s: str) -> bool:
        return s == s[::-1]
    
    """
    알고리즘 접근은 좋았지만, 하나를 놓쳐서 계속 시도한 케이스. 끝까지 변수가 어떤 값을 가지는 지 잘 확인하자!
    """
 

# 책 풀이    
class Solution:
    def longestPalindrome(self, s: str) -> str:
        def expand(left:int, right:int) -> str:
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1: right]
        
        if len(s) < 2 or s == s[::-1]:
            return s
        
        result = ''
        for i in range(len(s) - 1):
            result = max(result,
                         expand(i, i + 1),
                         expand(i, i + 2),
                         key = len)
        
        return result
    
    """
    1. max에도 key를 설정할 수 있다.
    2. 투 포인터를 설정해, 문제를 접근할 수 있다. (다양한 관점을 동시에 접근)
    """
    
        
