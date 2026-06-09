# Reverse Linked List

**LeetCode #:** 206  **Difficulty:** Easy

## Problem
Given the head of a singly linked list, reverse the list and return the new head.

## Approach (Recursive)
- Base case: empty list or single node → return as-is
- Recurse to the end to get `newHead`
- On the way back: `head.next.next = head` (reverse the pointer), `head.next = null` (break old forward link)

## Algorithm
1. If `head == null` or `head.next == null` → return `head`
2. Recurse: `newHead = reverseList(head.next)`
3. Let `front = head.next` (the node after current)
4. Set `front.next = head` (reverse the pointer)
5. Set `head.next = null` (sever the old forward link)
6. Return `newHead` (the original last node, now the new head)

## Complexity
- Time: O(n) — visits every node once
- Space: O(n) — recursion call stack (iterative approach uses O(1) space)

## Key Concepts
- The recursive call reaches the last node first; pointer reversal happens on the way back up
- Setting `head.next = null` is critical to avoid a cycle at the old tail

## Code Reference
[ReverseLinkedList.java](../../linkedlist/ReverseLinkedList.java)
