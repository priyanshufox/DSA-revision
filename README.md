# DSA — Data Structures & Algorithms (Java)

Java source files are organized by topic. Compiled `.class` files are kept separate in `bin/` and are git-ignored.

```
dsa/
├── graphs/
│   └── Bfs.java
├── bin/          ← auto-generated, do not edit
├── Makefile
└── .gitignore
```

## Usage

All commands must be run from the **repo root** (`dsa/`), not from inside a topic folder.

### Compile all Java files
```
make compile
```
Compiles every `.java` file in the repo and outputs `.class` files to `bin/`.

### Run a class
```
make run CLASS=Bfs
```
Replace `Bfs` with the name of any compiled class.

### Clean compiled output
```
make clean
```
Deletes the `bin/` directory entirely.

## Notes

Topic-wise notes with algorithm walkthroughs, complexity analysis, and key concepts.

| Topic | Notes |
|-------|-------|
| Graphs | [index](notes/1.graphs/index.md) · [BFS](notes/1.graphs/bfs.md) · [DFS](notes/1.graphs/dfs.md) · [Clone Graph](notes/1.graphs/clone-graph.md) · [No. of Provinces](notes/1.graphs/no-of-provinces.md) |
| Trees | [index](notes/2.trees/index.md) · [Balanced BT](notes/2.trees/balanced-binary-tree.md) · [Max Depth](notes/2.trees/max-depth-binary-tree.md) · [Same Tree](notes/2.trees/same-tree.md) |
| Linked List | [index](notes/3.linkedlist/index.md) · [Reverse](notes/3.linkedlist/reverse-linked-list.md) · [Add Two Numbers](notes/3.linkedlist/add-two-numbers.md) · [Merge Sorted](notes/3.linkedlist/merge-two-sorted-lists.md) · [Cycle](notes/3.linkedlist/linked-list-cycle.md) |
| Bit Manipulation | [index](notes/4.bitmanipulation/index.md) · [Reverse Bits](notes/4.bitmanipulation/reverse-bits.md) |

## Adding new files

Create `.java` files inside the relevant topic folder (or a new one):
```
graphs/Bfs.java
trees/Dfs.java
sorting/QuickSort.java
```
Then run `make compile` from the repo root — it picks up all `.java` files automatically.
