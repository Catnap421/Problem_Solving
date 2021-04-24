# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        # 길이를 알 수 없음
        # 투 포인터로 가능?
        headList = ""
        while head != None:
            headList += str(head.val)
            head = head.next
            
        return headList == headList[::-1]
            
        