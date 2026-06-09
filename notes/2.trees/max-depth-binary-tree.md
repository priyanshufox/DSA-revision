# Maximum Depth of Binary Tree

**LeetCode #:** 104  **Difficulty:** Easy

## Problem
Given the root of a binary tree, return its maximum depth (number of nodes along the longest path from root to a leaf).

## Approach
- Base case: `null` node returns depth 0
- Recursively compute max depth of left and right subtrees
- Return `max(leftDepth, rightDepth) + 1`

## Algorithm
1. If `root == null` → return 0
2. Recursively compute `leftDepth = maxDepth(root.left)`
3. Recursively compute `rightDepth = maxDepth(root.right)`
4. Return `max(leftDepth, rightDepth) + 1`

## Complexity
- Time: O(n) — every node visited exactly once
- Space: O(h) — recursion stack depth equals tree height (O(log n) balanced, O(n) skewed)

## Key Concepts
- Classic post-order DFS: compute children first, then use their results at the current node
- The `+1` accounts for the current node itself

## Code Reference
[MaxDepthBinaryTree.java](../../trees/MaxDepthBinaryTree.java)
