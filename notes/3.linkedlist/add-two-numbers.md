# Add Two Numbers

**LeetCode #:** 2  **Difficulty:** Medium

## Problem
Two non-negative integers are stored in reverse order in linked lists. Add them and return the sum as a linked list (also in reverse order).

## Approach
- Use a dummy head node and a `carry` variable
- Traverse both lists simultaneously, summing digits + carry at each step
- `digit = sum % 10`, `carry = sum / 10`; append digit node to result
- Continue while either list has nodes or carry is non-zero

## Algorithm
1. Create `dummy = new ListNode(-1)`; set `temp = dummy`; initialize `carry = 0`
2. While `l1 != null` OR `l2 != null` OR `carry != 0`:
   - Start `sum = carry`
   - If `l1 != null` → `sum += l1.val`; advance `l1`
   - If `l2 != null` → `sum += l2.val`; advance `l2`
   - `carry = sum / 10`; `digit = sum % 10`
   - Append `new ListNode(digit)` to result; advance `temp`
3. Return `dummy.next`

## Complexity
- Time: O(max(m, n)) — traverses both lists once
- Space: O(max(m, n)) — result list length is at most max(m,n)+1

## Key Concepts
- Dummy node avoids special-casing the first node
- The loop condition `l1 != null || l2 != null || carry != 0` handles lists of different lengths and a final carry

## Code Reference
[Add2Num.java](../../linkedlist/Add2Num.java)
