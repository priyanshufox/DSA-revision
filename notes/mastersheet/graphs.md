# Graphs — Master Sheet

## What is a Graph?
A graph is a set of **nodes (vertices)** connected by **edges**.
- **Undirected** — edges have no direction (friendship)
- **Directed (Digraph)** — edges have direction (follow on Twitter)
- **Weighted** — edges have a cost/weight
- **Cyclic / Acyclic** — contains cycles or not (DAG = Directed Acyclic Graph)

---

## Representations

### Adjacency List — preferred for sparse graphs
```java
List<List<Integer>> adj = new ArrayList<>();
for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

// Undirected edge u–v
adj.get(u).add(v);
adj.get(v).add(u);

// Directed edge u→v
adj.get(u).add(v);
```

### Adjacency Matrix — preferred for dense graphs / O(1) edge lookup
```java
int[][] matrix = new int[n][n];
matrix[u][v] = 1; // directed
matrix[v][u] = 1; // undirected (add this line too)
```

| | Adjacency List | Adjacency Matrix |
|--|---------------|-----------------|
| Space | O(V + E) | O(V²) |
| Edge lookup | O(degree) | O(1) |
| Best for | Sparse | Dense |

---

## BFS (Breadth-First Search)

**Explores level by level.** Uses a Queue.

```java
boolean[] visited = new boolean[n];
Queue<Integer> queue = new LinkedList<>();

visited[start] = true;
queue.add(start);

while (!queue.isEmpty()) {
    int node = queue.poll();
    // process node here

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            visited[neighbor] = true;
            queue.add(neighbor);
        }
    }
}
```

**Use BFS when:**
- Finding **shortest path** in an unweighted graph
- Level-order / layer-by-layer processing
- Minimum number of steps/moves

---

## DFS (Depth-First Search)

**Goes as deep as possible before backtracking.** Uses recursion (or a stack).

```java
boolean[] visited = new boolean[n];

void dfs(int node) {
    visited[node] = true;
    // process node here

    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(neighbor);
        }
    }
}
```

**Use DFS when:**
- Counting connected components
- Detecting cycles
- Path existence between two nodes
- Topological sort
- Exploring all possibilities (backtracking)

---

## Connected Components

Run DFS/BFS from every unvisited node. Each new start = one new component.

```java
int components = 0;
for (int i = 0; i < n; i++) {
    if (!visited[i]) {
        components++;
        dfs(i); // marks all nodes in this component
    }
}
```

---

## Cycle Detection

### Undirected Graph
Track the parent — if a visited neighbor is not the parent, there's a cycle.
```java
boolean hasCycle(int node, int parent) {
    visited[node] = true;
    for (int nb : adj.get(node)) {
        if (!visited[nb]) {
            if (hasCycle(nb, node)) return true;
        } else if (nb != parent) return true; // back edge = cycle
    }
    return false;
}
```

### Directed Graph (3-color DFS)
- `0` = unvisited, `1` = in current DFS path (gray), `2` = fully processed (black)
```java
int[] color = new int[n]; // 0=white, 1=gray, 2=black

boolean hasCycle(int node) {
    color[node] = 1; // mark as in-progress
    for (int nb : adj.get(node)) {
        if (color[nb] == 1) return true; // back edge
        if (color[nb] == 0 && hasCycle(nb)) return true;
    }
    color[node] = 2; // fully done
    return false;
}
```

---

## Topological Sort

Only valid for **DAGs**. Order nodes so all directed edges go left → right.

### Kahn's Algorithm (BFS — indegree)
```java
int[] indegree = new int[n];
for (int u = 0; u < n; u++)
    for (int v : adj.get(u)) indegree[v]++;

Queue<Integer> q = new LinkedList<>();
for (int i = 0; i < n; i++) if (indegree[i] == 0) q.add(i);

List<Integer> order = new ArrayList<>();
while (!q.isEmpty()) {
    int node = q.poll();
    order.add(node);
    for (int nb : adj.get(node))
        if (--indegree[nb] == 0) q.add(nb);
}
// if order.size() != n → cycle exists
```

### DFS Post-order
```java
// Push to stack after all neighbors processed; reverse stack = topo order
void dfs(int node) {
    visited[node] = true;
    for (int nb : adj.get(node))
        if (!visited[nb]) dfs(nb);
    stack.push(node); // add AFTER recursion
}
```

---

## Shortest Path

| Algorithm | Graph type | Time |
|-----------|-----------|------|
| BFS | Unweighted | O(V + E) |
| Dijkstra | Weighted, non-negative | O((V + E) log V) |
| Bellman-Ford | Weighted, negative edges | O(V × E) |
| Floyd-Warshall | All-pairs | O(V³) |

### Dijkstra (min-heap)
```java
int[] dist = new int[n];
Arrays.fill(dist, Integer.MAX_VALUE);
dist[src] = 0;

PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
pq.offer(new int[]{src, 0});

while (!pq.isEmpty()) {
    int[] curr = pq.poll();
    int node = curr[0], d = curr[1];
    if (d > dist[node]) continue; // stale entry
    for (int[] edge : adj.get(node)) { // {neighbor, weight}
        int nb = edge[0], w = edge[1];
        if (dist[node] + w < dist[nb]) {
            dist[nb] = dist[node] + w;
            pq.offer(new int[]{nb, dist[nb]});
        }
    }
}
```

---

## Union-Find (Disjoint Set Union)

Used for: connected components, cycle detection in undirected graphs, Kruskal's MST.

```java
int[] parent, rank;

void init(int n) {
    parent = new int[n]; rank = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
}

int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]); // path compression
    return parent[x];
}

boolean union(int x, int y) {
    int px = find(x), py = find(y);
    if (px == py) return false; // already connected — cycle!
    if (rank[px] < rank[py]) { int t = px; px = py; py = t; }
    parent[py] = px;
    if (rank[px] == rank[py]) rank[px]++;
    return true;
}
```

---

## Grid Graphs (2D)

Treat each cell as a node; neighbors are up/down/left/right.
```java
int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

void dfs(int r, int c) {
    visited[r][c] = true;
    for (int[] d : dirs) {
        int nr = r + d[0], nc = c + d[1];
        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc])
            dfs(nr, nc);
    }
}
```

---

## Complexity Summary

| Algorithm | Time | Space |
|-----------|------|-------|
| BFS | O(V + E) | O(V) |
| DFS | O(V + E) | O(V) |
| Topological sort | O(V + E) | O(V) |
| Dijkstra | O((V+E) log V) | O(V) |
| Union-Find (with compression) | O(α(n)) ≈ O(1) per op | O(V) |

---

## Pattern → Technique

| Problem type | Use |
|-------------|-----|
| Shortest path, unweighted | BFS |
| Shortest path, weighted | Dijkstra |
| Connected components | DFS/BFS + loop all nodes |
| Cycle — undirected | DFS + parent tracking |
| Cycle — directed | DFS 3-color OR Kahn's (check size) |
| Dependency ordering | Topological sort |
| Dynamic connectivity | Union-Find |
| Island / region count | DFS/BFS on 2D grid |

---

## Edge Cases
- Disconnected graph → loop all nodes; single DFS misses other components
- Self-loops → skip `u == v` when building adjacency list
- Parallel edges → allowed in most problems unless stated
- Empty graph → return 0 / null early
- Directed vs undirected → adding edge in both directions matters
