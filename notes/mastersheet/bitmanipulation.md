# Bit Manipulation — Master Sheet

## What is Bit Manipulation?
Operating directly on the binary representation of integers using bitwise operators. Works in O(1) time and O(1) space for fixed-width integers (32-bit `int`, 64-bit `long`).

In Java, `int` = 32 bits (signed), `long` = 64 bits (signed). Negative numbers use **two's complement**.

---

## Bitwise Operators

| Operator | Symbol | Rule | Example (`5=101`, `3=011`) |
|----------|--------|------|---------------------------|
| AND | `&` | 1 only if both are 1 | `5 & 3 = 1` (001) |
| OR | `\|` | 1 if either is 1 | `5 \| 3 = 7` (111) |
| XOR | `^` | 1 if bits differ | `5 ^ 3 = 6` (110) |
| NOT | `~` | Flip all bits | `~5 = -6` |
| Left shift | `<<` | Shift bits left, fill 0s | `1 << 3 = 8` |
| Right shift (signed) | `>>` | Shift right, fill with sign bit | `-8 >> 1 = -4` |
| Right shift (unsigned) | `>>>` | Shift right, always fill 0 | `-1 >>> 1 = 2147483647` |

---

## Bit Reading & Writing

```java
// Check if bit i is set (0-indexed from right)
boolean isSet = (n & (1 << i)) != 0;

// Set bit i (force to 1)
n = n | (1 << i);

// Clear bit i (force to 0)
n = n & ~(1 << i);

// Toggle bit i (flip)
n = n ^ (1 << i);

// Get value of bit i (0 or 1)
int bit = (n >> i) & 1;
```

---

## LSB (Lowest Set Bit) Tricks

```java
int lsb     = n & 1;      // 0 or 1 — value of the rightmost bit
int lsbMask = n & (-n);   // isolates the lowest SET bit (e.g. 0110 → 0010)
n = n & (n - 1);          // clears the lowest SET bit (used in bit-count loops)
```

---

## Common Operations

```java
// Is power of 2?
boolean isPow2 = n > 0 && (n & (n - 1)) == 0;

// Absolute value of a number
int mask = n >> 31;       // all 0s (positive) or all 1s (negative)
int abs  = (n + mask) ^ mask;

// Swap two variables without temp
a ^= b; b ^= a; a ^= b;

// Multiply / divide by 2
int doubled  = n << 1;
int halved   = n >> 1;

// Check if two integers have opposite signs
boolean opposite = (a ^ b) < 0;
```

---

## Counting Set Bits

```java
// Brian Kernighan — O(k), k = number of set bits
int countBits(int n) {
    int count = 0;
    while (n != 0) { n &= (n - 1); count++; } // each iteration clears one set bit
    return count;
}

// Built-in
int count = Integer.bitCount(n); // O(1)
```

---

## Reverse All 32 Bits

```java
int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1); // shift result left, bring in LSB of n
        n >>= 1;
    }
    return result;
}
```

---

## XOR Properties & Patterns

```
a ^ 0 = a          (XOR with 0 keeps value)
a ^ a = 0          (XOR with self = 0)
a ^ b ^ a = b      (XOR is commutative + associative)
```

```java
// Find the one element that appears an odd number of times
int unique = 0;
for (int x : arr) unique ^= x; // all duplicates cancel out

// Find missing number in 0..n
int missing = n;
for (int i = 0; i < n; i++) missing ^= i ^ nums[i];
```

---

## Bitmask DP / Subset Enumeration

```java
// Enumerate all subsets of a set of n elements
for (int mask = 0; mask < (1 << n); mask++) {
    for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
            // element i is in this subset
        }
    }
}

// Enumerate all subsets of a given mask
for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
    // process sub
}
```

---

## Bit Tricks with Two's Complement

- `-n = ~n + 1` (negation via NOT + 1)
- `~n = -(n+1)`
- `n & (-n)` = lowest set bit of n
- For 32-bit: `n >>> 31` = sign bit (0 for positive, 1 for negative)

---

## Complexity Summary

| Operation | Time | Space |
|-----------|------|-------|
| Any single bit op (`&`, `\|`, `^`, `~`, shifts) | O(1) | O(1) |
| Reverse 32-bit integer | O(1) — 32 iterations | O(1) |
| Count set bits (Kernighan) | O(k) — k = set bits | O(1) |
| Enumerate all subsets | O(2ⁿ) | O(1) |
| `Integer.bitCount` | O(1) | O(1) |

---

## Pattern → Technique

| Problem type | Technique |
|-------------|-----------|
| Reverse all bits | 32-iteration loop with shift |
| Count set bits | `n & (n-1)` loop OR `Integer.bitCount` |
| Find single unique element | XOR all values |
| Find missing number | XOR indices with values |
| Check / set / clear bit | `&`, `\|`, `& ~` with `1 << i` |
| Check power of 2 | `n > 0 && (n & (n-1)) == 0` |
| Subset enumeration | Bitmask from `0` to `1<<n` |
| Two numbers appear once (others twice) | XOR → split by differing bit |

---

## Key Identities
| Identity | Value |
|----------|-------|
| `a & 0` | `0` |
| `a & a` | `a` |
| `a \| 0` | `a` |
| `a \| a` | `a` |
| `a ^ 0` | `a` |
| `a ^ a` | `0` |
| `~a` | `-(a+1)` |
| `a & (a-1)` | clears lowest set bit |
| `a & (-a)` | isolates lowest set bit |

---

## Edge Cases
- Java `>>` is **arithmetic** (fills sign bit); use `>>>` for logical right shift on negative numbers
- Use `1L << i` (not `1 << i`) for 64-bit / `long` operations
- `Integer.MIN_VALUE` has only the MSB set; `~Integer.MIN_VALUE = Integer.MAX_VALUE`
- XOR swap fails if `a` and `b` point to the same variable — results in 0
