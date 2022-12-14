'''
Recursion approach

56ms 51.26
13.8mb 57.11
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def invert(node):
            if node.left:
                invert(node.left)
            if node.right:
                invert(node.right)
            temp = node.left
            node.left = node.right
            node.right = temp
        if root:
            invert(root)
        return root
