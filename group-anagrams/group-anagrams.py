class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = []
        temp_anagram = ""
        answer = []
        replaced_strs = [(idx, ''.join(sorted(list(word)))) for idx, word in enumerate(strs)]
        sorted_strs = sorted(replaced_strs, key=lambda x: x[1])
        for word in sorted_strs:
            if len(anagrams) == 0:
                anagrams.append(strs[word[0]])
                temp_anagram = word[1]
            elif temp_anagram == word[1]:
                anagrams.append(strs[word[0]])
            else:
                answer.append(anagrams)
                anagrams = []
                anagrams.append(strs[word[0]])
                temp_anagram = word[1]
                
        answer.append(anagrams)

        return answer
    
    """
    이렇게 temp를 이용해 이전 배열의 원소와 비교해 return하는 경우는 꼭 마지막 경우를 생각하는 습관을 들이자!
    (like 19 lines)
    
    # 다른 풀이
    애너그램의 문제의 경우, 정렬한 단어를 key로 하는 딕셔너리를 만들어 해결이 가능!
    
    anagrams = collections.defaultdict(list)
    
    for word in strs:
        anagrams[''.join(sorted(word))].append(word)
    return list(anagrams.values())

    """
            
        
