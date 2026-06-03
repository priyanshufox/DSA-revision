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

## Adding new files

Create `.java` files inside the relevant topic folder (or a new one):
```
graphs/Bfs.java
trees/Dfs.java
sorting/QuickSort.java
```
Then run `make compile` from the repo root — it picks up all `.java` files automatically.
