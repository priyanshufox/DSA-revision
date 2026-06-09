# Balanced Binary Tree

**LeetCode #:** 110  **Difficulty:** Easy

## Problem
Given a binary tree, determine if it is height-balanced (the height difference between left and right subtrees of every node is at most 1).

## Approach
- Helper `height(node)` returns the height of the subtree rooted at `node` (0 for null)
- `isBalanced(node)` checks: `|height(left) - height(right)| <= 1` at the current node, then recurses on both children

## Algorithm
1. Define `height(node)`:
   - If `node == null` → return 0
   - Return `1 + max(height(node.left), height(node.right))`
2. Define `isBalanced(node)`:
   - If `node == null` → return `true`
   - If `|height(node.left) - height(node.right)| > 1` → return `false`
   - Return `isBalanced(node.left) && isBalanced(node.right)`

## Complexity
- Time: O(n²) — `height` is called for every node, and itself traverses the subtree
- Space: O(h) — recursion stack depth equals tree height

## Key Concepts
- Can be optimized to O(n) by returning -1 from `height` when imbalance is detected (early exit)
- Current implementation is clean and correct but redundantly recomputes heights

## Code Reference
[BalancedBinaryTree.java](../../trees/BalancedBinaryTree.java)
