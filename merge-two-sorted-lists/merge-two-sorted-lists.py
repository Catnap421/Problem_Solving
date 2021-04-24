# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        headL1 = l1
        headL2 = l2
        ret = ListNode()
        headRet = ret
        while headL1 != None and headL2 != None:
            if headL1.val > headL2.val:
                ret.next = headL2
                headL2 = headL2.next
            elif headL1.val <= headL2.val:
                ret.next = headL1
                headL1 = headL1.next
            ret = ret.next
        
        while headL1 != None:
            ret.next = headL1
            headL1 = headL1.next
            ret = ret.next

        while headL2 != None:
            ret.next = headL2
            headL2 = headL2.next
            ret = ret.next

        return headRet.next
        