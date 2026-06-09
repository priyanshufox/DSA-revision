# Merge Two Sorted Lists

**LeetCode #:** 21  **Difficulty:** Easy

## Problem
Merge two sorted linked lists and return the head of the merged sorted list (in-place, reusing existing nodes).

## Approach
- Use a dummy head node; maintain a `temp` pointer to the tail of the result
- Compare the heads of both lists; append the smaller node to result and advance that list's pointer
- After one list is exhausted, append the remainder of the other directly

## Algorithm
1. Create `dummy = new ListNode(-1)`; set `temp = dummy`
2. While both `t1 != null` AND `t2 != null`:
   - If `t1.val <= t2.val` → `temp.next = t1`; advance `t1`
   - Else → `temp.next = t2`; advance `t2`
   - Advance `temp`
3. If `t1 != null` → `temp.next = t1`; else `temp.next = t2`
4. Return `dummy.next`

## Complexity
- Time: O(m + n) — each node is visited once
- Space: O(1) — no new nodes created; only pointer reassignment

## Key Concepts
- Dummy node eliminates the need to handle an empty result list separately
- Appending the leftover tail with `temp.next = remaining` avoids an extra loop

## Code Reference
[MergeTwoLinkedList.java](../../linkedlist/MergeTwoLinkedList.java)
