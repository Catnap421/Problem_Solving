from functools import reduce
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # 전부 다 곱해서 나누기는 불가능
        cnt_zero = nums.count(0)
        if cnt_zero > 1:
            answer = [0] * len(nums)
        elif cnt_zero == 1:
            idx_zero = nums.index(0)
            mul = reduce(lambda acc, cur: acc * cur, nums[:idx_zero] + nums[idx_zero + 1:])
            answer = [0] * len(nums)
            answer[idx_zero] = mul
        else:
            mul = reduce(lambda acc, cur: acc * cur, nums)
            answer = list(map(lambda x: mul // x, nums))
        
        return answer

            