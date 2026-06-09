# Linked List

## Key Concepts
- **Dummy node** — a sentinel head (`new ListNode(-1)`) avoids null-checks when building a new list
- **Two pointers** — slow/fast pointers detect cycles (Floyd's algorithm) or find midpoints
- **Carry propagation** — digit-by-digit arithmetic on lists needs `carry = sum / 10`
- **In-place reversal** — track `prev`, `curr`, `next` to reverse pointers iteratively, or unwind recursively
- **Merge pattern** — compare heads of two lists and stitch in order using a dummy node

## Problems

| Problem | LeetCode # | Difficulty | Note |
|---------|-----------|-----------|------|
| Reverse Linked List | #206 | Easy | [reverse-linked-list.md](reverse-linked-list.md) |
| Add Two Numbers | #2 | Medium | [add-two-numbers.md](add-two-numbers.md) |
| Merge Two Sorted Lists | #21 | Easy | [merge-two-sorted-lists.md](merge-two-sorted-lists.md) |
| Linked List Cycle | #141 | Easy | [linked-list-cycle.md](linked-list-cycle.md) |
