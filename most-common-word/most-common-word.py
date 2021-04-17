class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        import collections
        changed_paragraph = ""
        for ch in paragraph.lower():
            if ch.isalpha() or ch.isspace():
                changed_paragraph += ch
            else:
                changed_paragraph += ' '
        
        words = collections.Counter(changed_paragraph.split())
        print(words)
        for word in words.most_common():
            if word[0] not in banned:
                return word[0]
            
        # str.isspace() 문법 존재
        # collections.Counter 객체의 메서드로 most_common()이 존재하며, 모든 원소를 반환한다!
                
        