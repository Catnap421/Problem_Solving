class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digits, letters = [], []
        for log in logs:
            if log.split()[1].isdigit():
                digits.append(log)
            else:
                letters.append(log)
        
        sorted_logs = sorted(letters, key=lambda x: (x.split()[1:], x.split()[0]))
        return sorted_logs + digits
        
        # 이러한 정렬 문제에 특히나 약점을 보인다! 복습하자!
        # 정렬에서 동일한 값일 경우, 후순위 식별자를 아래와 같이 설정할 수 있다!! 명심해두자
        # sorted_logs = sorted(letters, key=lambda x: (x.split()[1:], x.split()[0]))
