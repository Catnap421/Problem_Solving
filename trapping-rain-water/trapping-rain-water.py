class Solution:
    def trap(self, height: List[int]) -> int:  
        if not height:
            return 0
        
        volume = 0
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        
        while left < right:
            left_max, right_max = max(height[left], left_max), max(height[right], right_max)
            
            if left_max <= right_max:
                volume += left_max - height[left]
                left += 1
            else:
                volume += right_max - height[right]
                right -= 1
            
        return volume
    
    """
    책 풀이를 그대로 가져옴.
    어려운 문제인 건 확실. 문제의 정의를 제대로 정리하지 못한 게 원인!
    
    def trap(self, height: List[int]) -> int:
        stack = []
        volume = 0
        
        for i in range(len(height)):
            # 변곡점을 만난 경우(이전보다 커질 때)
            while stack and height[i] > height[stack[-1]]:
                top = stack.pop()
                
                if not len(stack):
                    break
                
                # 이전과의 차이만큼 물 높이 처리
                distance = i - stack[-1] - 1
                waters = min(height[i], height[stack[-1]] - height[top])
                
                volume += distance * waters
                
            stack.append(i)
        return volume
    
    """
                
            
        