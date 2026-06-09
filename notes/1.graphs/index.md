# Graphs

## Key Concepts
- **Adjacency List** — space-efficient graph representation using `ArrayList<ArrayList<Integer>>`
- **BFS** — level-order traversal using a Queue; good for shortest path in unweighted graphs
- **DFS** — depth-first traversal using recursion (or a stack); good for connected components, cycle detection
- **Visited array** — prevents re-visiting nodes in both BFS and DFS
- **Connected Components** — disjoint subgraphs; count by running DFS/BFS from each unvisited node

## Problems

| Problem | LeetCode # | Difficulty | Note |
|---------|-----------|-----------|------|
| BFS | — | Fundamentals | [bfs.md](bfs.md) |
| DFS | — | Fundamentals | [dfs.md](dfs.md) |
| Clone Graph | #133 | Medium | [clone-graph.md](clone-graph.md) |
| Number of Provinces | #547 | Medium | [no-of-provinces.md](no-of-provinces.md) |
