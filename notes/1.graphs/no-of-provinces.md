# Number of Provinces

**LeetCode #:** 547  **Difficulty:** Medium

## Problem
Given an `n x n` matrix `isConnected` where `isConnected[i][j] = 1` means city `i` and `j` are directly connected, return the total number of provinces (connected components).

## Approach
- Convert the adjacency matrix to an adjacency list
- Iterate over all nodes; for each unvisited node, increment the province count and run DFS to mark all reachable nodes as visited

## Algorithm
1. Build adjacency list: for each `(i, j)` where `isConnected[i][j] == 1` and `i != j`, add `j` to `adjList[i]` and `i` to `adjList[j]`
2. Create a `visited[]` int array (0 = unvisited); initialize province count `c = 0`
3. For each node `i` from `0` to `n-1`:
   - If `visited[i] == 0`:
     - Increment `c`
     - Run DFS from `i` to mark all reachable nodes as visited
4. In DFS: mark node as visited, then recurse on each unvisited neighbor
5. Return `c`

## Complexity
- Time: O(n²) — building adjacency list from matrix; DFS is O(V + E) but E ≤ n²
- Space: O(n) — visited array + recursion stack

## Key Concepts
- Each DFS call from an unvisited node discovers exactly one connected component
- Number of times DFS is initiated = number of provinces

## Code Reference
[NoOfProvinces.java](../../graphs/NoOfProvinces.java)
