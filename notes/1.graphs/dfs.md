# Depth-First Search (DFS)

**Difficulty:** Fundamentals

## Problem
Traverse all nodes of a graph by going as deep as possible before backtracking, returning the DFS order.

## Approach
- Use recursion with a `visited[]` boolean array
- Mark the current node as visited and add to result
- Recursively visit each unvisited neighbor

## Algorithm
1. Create a `visited[]` boolean array of size = number of nodes
2. Call `dfsHelper(start, graph, visited, result)`
3. In `dfsHelper`:
   - Mark `node` as visited
   - Add `node` to result list
   - For each neighbor of `node`:
     - If neighbor is not visited → recursively call `dfsHelper(neighbor, ...)`
4. Return the result list

## Complexity
- Time: O(V + E) — each vertex and edge is processed once
- Space: O(V) — visited array + recursion call stack

## Key Concepts
- Recursion stack naturally handles backtracking
- Visit before recursing to avoid infinite loops in cyclic graphs

## Code Reference
[Dfs.java](../../graphs/Dfs.java)
