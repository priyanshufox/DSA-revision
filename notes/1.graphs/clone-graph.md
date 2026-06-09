# Clone Graph

**LeetCode #:** 133  **Difficulty:** Medium

## Problem
Given a reference to a node in a connected undirected graph, return a deep copy (clone) of the graph.

## Approach
- Use a `HashMap<Integer, Node>` to map original node values to their clones (acts as visited set)
- For each node: create a copy, store it in the map, then recursively clone each neighbor
- If a neighbor is already in the map, reuse the existing clone (avoids cycles)

## Algorithm
1. If input node is `null`, return `null`
2. Create a new `Node` with the same value; store it in `visited` map keyed by value
3. For each neighbor of the original node:
   - If neighbor's value is **not** in `visited` → recursively clone it (step 2–4)
   - Add the cloned neighbor to the current copy's neighbors list
4. Return the cloned node

## Complexity
- Time: O(V + E) — each node and edge visited once
- Space: O(V) — hashmap stores one entry per node

## Key Concepts
- The visited map serves double duty: detects already-cloned nodes AND provides the clone reference
- Without the map, cycles would cause infinite recursion

## Code Reference
[CloneGraph.java](../../graphs/CloneGraph.java)
