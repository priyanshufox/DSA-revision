# Same Tree

**LeetCode #:** 100  **Difficulty:** Easy

## Problem
Given the roots of two binary trees `p` and `q`, check whether they are structurally identical with the same node values.

## Approach
- Base case: both null → `true`; one null (but not the other) or values differ → `false`
- Recursively check that left subtrees are the same AND right subtrees are the same

## Algorithm
1. If both `p == null` and `q == null` → return `true`
2. If either is `null` (but not both), or `p.val != q.val` → return `false`
3. Return `isSameTree(p.left, q.left) && isSameTree(p.right, q.right)`

## Complexity
- Time: O(n) — visits every node at most once (short-circuits on mismatch)
- Space: O(h) — recursion stack proportional to tree height

## Key Concepts
- The three-condition base case handles null and value-mismatch in one line
- Short-circuit evaluation (`&&`) stops recursion as soon as a mismatch is found

## Code Reference
[SameTree.java](../../trees/SameTree.java)
