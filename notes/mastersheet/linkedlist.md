# Linked List — Master Sheet

## What is a Linked List?
A **linked list** is a linear data structure where each element (node) holds a value and a pointer to the next node. Unlike arrays, nodes are not stored contiguously — no random access by index.

```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

| Type | Description |
|------|-------------|
| Singly Linked | Each node points to next only |
| Doubly Linked | Each node has `next` and `prev` |
| Circular | Last node points back to head |

---

## Core Pointer Operations

### Traverse
```java
ListNode curr = head;
while (curr != null) {
    // process curr.val
    curr = curr.next;
}
```

### Insert at head
```java
ListNode newNode = new ListNode(val);
newNode.next = head;
head = newNode;
```

### Insert at tail
```java
ListNode curr = head;
while (curr.next != null) curr = curr.next;
curr.next = new ListNode(val);
```

### Delete a node (given previous)
```java
prev.next = prev.next.next;
```

---

## Dummy Head Pattern

Eliminates null checks when building or modifying a list.
```java
ListNode dummy = new ListNode(-1);
ListNode tail = dummy;

// append nodes
tail.next = new ListNode(val);
tail = tail.next;

return dummy.next; // actual head
```

---

## Two Pointer Techniques

### Fast & Slow (Floyd's)
```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
// slow → middle node (left-mid for even-length lists)
```

Use for: **find middle**, **cycle detection**, **cycle start**, **palindrome check**.

### Gap Pointer (k apart)
```java
ListNode fast = head, slow = head;
for (int i = 0; i < k; i++) fast = fast.next;
while (fast != null) { slow = slow.next; fast = fast.next; }
// slow is now k steps from the end
```

Use for: **remove Nth from end**, **find kth from end**.

---

## Reverse a Linked List

### Iterative — O(n) time, O(1) space
```java
ListNode prev = null, curr = head;
while (curr != null) {
    ListNode next = curr.next; // save next
    curr.next = prev;          // reverse pointer
    prev = curr;               // move prev forward
    curr = next;               // move curr forward
}
return prev; // new head
```

### Recursive — O(n) time, O(n) space
```java
ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverse(head.next);
    head.next.next = head; // reverse pointer
    head.next = null;      // cut old forward link
    return newHead;
}
```

### Reverse a Sub-list (from position left to right)
```java
// Reach the node just before position left
// Then reverse exactly (right - left + 1) nodes
ListNode dummy = new ListNode(0); dummy.next = head;
ListNode pre = dummy;
for (int i = 0; i < left - 1; i++) pre = pre.next;

ListNode curr = pre.next, prev = null;
for (int i = 0; i < right - left + 1; i++) {
    ListNode next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
pre.next.next = curr; // connect tail of reversed to rest
pre.next = prev;      // connect pre to new head of reversed
return dummy.next;
```

---

## Cycle Detection & Entry Point

```java
// Detect cycle
boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next; fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}

// Find cycle entry node
ListNode cycleStart(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next; fast = fast.next.next;
        if (slow == fast) {
            slow = head; // reset one pointer to head
            while (slow != fast) { slow = slow.next; fast = fast.next; }
            return slow; // meeting point = cycle start
        }
    }
    return null;
}
```

---

## Merge Two Sorted Lists

```java
ListNode dummy = new ListNode(-1), curr = dummy;
while (l1 != null && l2 != null) {
    if (l1.val <= l2.val) { curr.next = l1; l1 = l1.next; }
    else                  { curr.next = l2; l2 = l2.next; }
    curr = curr.next;
}
curr.next = (l1 != null) ? l1 : l2; // attach remaining
return dummy.next;
```

---

## Find Middle

```java
ListNode slow = head, fast = head;
while (fast.next != null && fast.next.next != null) {
    slow = slow.next; fast = fast.next.next;
}
return slow; // left-middle for even length
```

---

## Remove Nth Node from End

```java
ListNode dummy = new ListNode(0); dummy.next = head;
ListNode fast = dummy, slow = dummy;
for (int i = 0; i <= n; i++) fast = fast.next; // advance fast by n+1
while (fast != null) { slow = slow.next; fast = fast.next; }
slow.next = slow.next.next; // skip the target node
return dummy.next;
```

---

## Complexity Summary

| Operation | Time | Space |
|-----------|------|-------|
| Access by index | O(n) | O(1) |
| Insert / delete at head | O(1) | O(1) |
| Insert / delete at tail | O(n) | O(1) |
| Reverse (iterative) | O(n) | O(1) |
| Reverse (recursive) | O(n) | O(n) |
| Cycle detection | O(n) | O(1) |
| Find middle | O(n) | O(1) |
| Merge two sorted | O(m + n) | O(1) |

---

## Pattern → Technique

| Problem type | Technique |
|-------------|-----------|
| Cycle exists? | Fast & slow pointers |
| Where does cycle start? | Fast & slow → reset slow to head → meet = start |
| Find middle | Fast & slow (stop when `fast.next == null`) |
| Nth from end | Two pointers with n-gap |
| Reverse entire list | Iterative 3-pointer |
| Reverse sub-list | Reach pre-node, reverse k nodes, reconnect |
| Build new list from two | Dummy head + tail pointer |
| Palindrome check | Find middle, reverse second half, compare |
| Detect intersection | Two pointer (equalize lengths or cycle trick) |

---

## Edge Cases
- Empty list (`head == null`) → return null / false immediately
- Single node → no cycle; middle = itself; reverse = itself
- Two nodes → check cycle and middle logic carefully
- Different length lists → use `||` not `&&` when traversing both simultaneously
- Off-by-one in gap pointer → `fast` should advance `n+1` steps (not `n`) to land `slow` on predecessor of target
