class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # 투 포인터를 활용한 책 풀이 - 꼭 다시 풀기!
        result = []
        nums.sort()
        
        for i in range(len(nums) - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue
            
            left, right = i + 1, len(nums) - 1
            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                
                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else:
                    result.append((nums[i], nums[left], nums[right]))
                    
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1
                        
                    left += 1
                    right -= 1
            
        return result
    
    

        
        """
        시간초과가 일어난 풀이
        
        def twoSum(nums: List[int], target: int) -> List[List[int]]:
            ret = []
            for idx, value in enumerate(nums):
                if target - value in (nums[:idx] + nums[idx + 1:]):
                    ret.append([value, target-value])
            return ret
        
        if len(nums) < 3:
            return []
        
        answer = []
        for idx, value in enumerate(nums):
            lists = twoSum(nums[:idx] + nums[idx + 1:], -value)
            if not lists:
                continue
            for el in lists: 
                el.append(value)
                el.sort()
                if el not in answer:
                    answer.append(el)            
        
        return answer
        
        # 수 하나를 선택 -> twoSum을 호출하여 Set을 반환 -> Set에 고른 수를 추가한 Set 생성
        
        import collections

        class Solution:
            def threeSum(self, nums: List[int]) -> List[List[int]]:
                result = set()
                num_dict = collections.Counter(nums)

                for i in num_dict:
                    num_dict[i] -= 1
                    for j in num_dict:
                        if num_dict[j]  < 1:
                            continue

                        num_dict[j] -= 1

                        rest = -j -i

                        if num_dict[rest]:
                            result.add(tuple(sorted((rest, j, i))))
                        num_dict[j] += 1
                    num_dict[i] += 1

                return [*map(list, result)]

        dictionary를 활용한 풀이
        1. list나 tuple이나 동일하게 인식한다는 점 -> 이러한 list set 경우 tuple 활용하기!
        2. unpacking operator인 * 활용하기!   
        """
        

                
        
        
