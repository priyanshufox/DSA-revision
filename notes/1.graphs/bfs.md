# Breadth-First Search (BFS)

**Difficulty:** Fundamentals

## Problem
Traverse all nodes of a graph level by level starting from a given source node, returning the BFS order.

## Approach
- Use a `Queue` and a `visited[]` boolean array
- Enqueue the start node and mark it visited
- While the queue is non-empty: dequeue a node, add it to result, enqueue all unvisited neighbors and mark them visited

## Algorithm
1. Create a `visited[]` boolean array of size = number of nodes
2. Create an empty `Queue` and an empty result list
3. Enqueue the start node; mark `visited[start] = true`
4. While the queue is not empty:
   - Dequeue a node → add it to result
   - For each neighbor of that node:
     - If neighbor is not visited → mark visited, enqueue it
5. Return the result list

## Complexity
- Time: O(V + E) — each vertex and edge is processed once
- Space: O(V) — visited array + queue

## Key Concepts
- Queue gives FIFO order → explores nodes layer by layer
- Marking visited **before** enqueue (not after dequeue) prevents duplicate enqueues

## Code Reference
[Bfs.java](../../graphs/Bfs.java)
