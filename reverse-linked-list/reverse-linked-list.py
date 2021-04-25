# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        stack = []
        while head != None:
            prev = head
            head = head.next
            prev.next = None
            stack.append(prev)
        print(stack)
        ret = ListNode()
        head = ret
        while stack:
            ret.next = stack.pop()
            ret = ret.next
        
        return head.next
        