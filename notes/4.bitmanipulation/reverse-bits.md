# Reverse Bits

**LeetCode #:** 190  **Difficulty:** Easy

## Problem
Reverse the bits of a given 32-bit unsigned integer and return the result.

## Approach
- Loop 32 times (one iteration per bit position)
- Each iteration: extract the LSB with `n & 1`, place it at position `31 - i` using left shift, OR it into `result`, then right-shift `n` to move to the next bit

## Algorithm
1. Initialize `result = 0`
2. For `i` from `0` to `31`:
   - Extract LSB: `lsb = n & 1`
   - Place it at mirrored position: `reversedBit = lsb << (31 - i)`
   - Accumulate: `result = result | reversedBit`
   - Shift input right: `n = n >> 1`
3. Return `result`

## Complexity
- Time: O(1) — fixed 32 iterations regardless of input
- Space: O(1)

## Key Concepts
- `n & 1` isolates the least significant bit
- `lsb << (31 - i)` places the bit at the correct mirrored position in the result
- `result |= reversedBit` accumulates bits without clearing previously set ones

## Code Reference
[ReverseBits.java](../../bit_manipulation/ReverseBits.java)
