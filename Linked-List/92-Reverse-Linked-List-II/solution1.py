# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
#
#----------Performance---------------
#Time: 60ms (30.27%)
#Memory: 14.5MB (7.99%)
#
#
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if left == right or head.next is None:
            return head
        anchor = ListNode(val = 1, next = head)
        return self.recursive(anchor.next, left, right, 1 , anchor)
        
    def recursive(self, node, left, right , counter, prev):
        if counter >= left:
            prev_next = node.next
            if counter == left:
                new_prev_next, new_next = self.recursive(prev_next, left, right,counter + 1, node)
                node.next = new_next
                return new_prev_next
            
            node.next = prev
            
            if counter == right:
                return node , prev_next
            
            return self.recursive(prev_next, left, right, counter + 1, node)
        node.next = self.recursive(node.next, left, right, counter + 1, node)
        return node
            
