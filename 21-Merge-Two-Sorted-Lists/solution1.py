'''
Use the normal recursion way

However it is slow

Time: 75ms 36.54%
Memory: 13.9MB 32.71%
'''
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        def merge(l1,l2,res):
            if l1 is None:
                if l2 is None:
                    return
                else:
                    res.next = l2
                    return
            if l2 is None:
                if l1 is None:
                    return
                else:
                    res.next = l1
                    return
            if l1.val < l2.val:
                res.next = l1
                merge(l1.next,l2,res.next)
            else:
                res.next = l2
                merge(l1,l2.next,res.next)
        
        res = ListNode(0,None)
        merge(list1,list2,res)
        return res.next
