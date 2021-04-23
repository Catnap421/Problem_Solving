class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # 최소값을 저장하고, max(이전 최대 ,(현재 값 - 최소))
        dp = 0
        min_num = 10 ** 4
        for el in prices:
            min_num = min(min_num, el)
            dp = max(dp, el - min_num)
        
        return dp
        