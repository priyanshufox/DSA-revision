# Bit Manipulation

## Key Concepts
- **AND (`&`)** — extract a specific bit: `n & 1` gives the LSB
- **OR (`|`)** — set a bit: `result | (1 << pos)`
- **Left shift (`<<`)** — multiply by 2 / move bit to higher position
- **Right shift (`>>`)** — divide by 2 / move bit to lower position (arithmetic; fills with sign bit)
- **Unsigned right shift (`>>>`)** — fills with 0 regardless of sign; needed for negative numbers
- **XOR (`^`)** — flip bits; `a ^ a = 0`, useful for finding unique elements

## Problems

| Problem | LeetCode # | Difficulty | Note |
|---------|-----------|-----------|------|
| Reverse Bits | #190 | Easy | [reverse-bits.md](reverse-bits.md) |
