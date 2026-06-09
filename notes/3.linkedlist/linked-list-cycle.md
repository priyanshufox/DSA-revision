# Linked List Cycle

**LeetCode #:** 141  **Difficulty:** Easy

## Problem
Given the head of a linked list, determine if there is a cycle (a node whose `next` pointer points back to a previous node).

## Approach (Floyd's Cycle Detection)
- Use two pointers: `slow` moves 1 step at a time, `fast` moves 2 steps
- If they ever point to the same node, a cycle exists
- If `fast` or `fast.next` becomes null, the list is finite (no cycle)

## Algorithm
1. Initialize `slow = head` and `fast = head`
2. While `fast != null` AND `fast.next != null`:
   - `slow = slow.next`
   - `fast = fast.next.next`
   - If `slow == fast` → return `true` (cycle detected)
3. Return `false` (reached end of list, no cycle)

## Complexity
- Time: O(n) — fast pointer laps slow pointer within one full cycle traversal
- Space: O(1) — only two pointers

## Key Concepts
- In a cyclic list, the fast pointer will always catch up to the slow pointer inside the cycle
- Check `fast != null && fast.next != null` to safely advance two steps

## Code Reference
[LinkedListCycle.java](../../linkedlist/LinkedListCycle.java)
