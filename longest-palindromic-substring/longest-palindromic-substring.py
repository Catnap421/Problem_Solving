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
        