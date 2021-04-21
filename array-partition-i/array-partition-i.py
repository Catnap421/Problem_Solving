class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        # 합이 최대가 되는 min의 쌍을 구하라

        nums.sort()
        answer = 0
        for i in nums[::2] :
            answer += i
            
        return answer