# Trees — Master Sheet

## What is a Tree?
A **tree** is an acyclic connected graph with `n` nodes and `n-1` edges. One node is the **root**; every other node has exactly one parent.

- **Binary Tree** — each node has at most 2 children (left, right)
- **BST (Binary Search Tree)** — left subtree values < node < right subtree values
- **Balanced Tree** — height O(log n); height difference of any node's subtrees ≤ 1
- **Complete Tree** — all levels full except possibly the last, filled left to right
- **Full Tree** — every node has 0 or 2 children

```java
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}
```

---

## Tree Traversals

### DFS Traversals (Recursive)
```java
// Preorder: Root → Left → Right  (use: copy/serialize tree)
void preorder(TreeNode node) {
    if (node == null) return;
    visit(node);
    preorder(node.left);
    preorder(node.right);
}

// Inorder: Left → Root → Right  (use: sorted output for BST)
void inorder(TreeNode node) {
    if (node == null) return;
    inorder(node.left);
    visit(node);
    inorder(node.right);
}

// Postorder: Left → Right → Root  (use: delete tree, compute from leaves)
void postorder(TreeNode node) {
    if (node == null) return;
    postorder(node.left);
    postorder(node.right);
    visit(node);
}
```

### BFS / Level-Order Traversal
```java
Queue<TreeNode> q = new LinkedList<>();
q.add(root);

while (!q.isEmpty()) {
    int levelSize = q.size(); // number of nodes at current level
    for (int i = 0; i < levelSize; i++) {
        TreeNode node = q.poll();
        visit(node);
        if (node.left != null)  q.add(node.left);
        if (node.right != null) q.add(node.right);
    }
    // after this loop, one level is processed
}
```

---

## Height and Depth

- **Height of a node** — longest path from the node down to a leaf
- **Depth of a node** — distance from root to the node
- **Height of tree** = height of root = max depth of any leaf

```java
int height(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.left), height(node.right));
}
```

---

## Key Recursive Patterns

### Bottom-up (post-order)
Compute a value from children first, then use it at the current node.
```java
int solve(TreeNode node) {
    if (node == null) return BASE_CASE;
    int left  = solve(node.left);
    int right = solve(node.right);
    return combine(left, right, node.val); // e.g. max, sum, height
}
```

### Top-down (pre-order)
Pass information from parent to children.
```java
void solve(TreeNode node, int valueFromParent) {
    if (node == null) return;
    int newValue = compute(valueFromParent, node.val);
    solve(node.left, newValue);
    solve(node.right, newValue);
}
```

---

## BST Properties & Operations

**Invariant:** `left.val < node.val < right.val` for every node.

```java
// Search — O(h)
TreeNode search(TreeNode root, int target) {
    if (root == null || root.val == target) return root;
    return target < root.val ? search(root.left, target) : search(root.right, target);
}

// Insert — O(h)
TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);
    if (val < root.val) root.left  = insert(root.left, val);
    else                root.right = insert(root.right, val);
    return root;
}

// Find min / max
TreeNode findMin(TreeNode root) {
    while (root.left != null) root = root.left;
    return root;
}

// Validate BST — pass min/max bounds down
boolean isValidBST(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (node.val <= min || node.val >= max) return false;
    return isValidBST(node.left, min, node.val)
        && isValidBST(node.right, node.val, max);
}
// call: isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
```

---

## Lowest Common Ancestor (LCA)

```java
// General binary tree
TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) return root;
    TreeNode left  = lca(root.left, p, q);
    TreeNode right = lca(root.right, p, q);
    if (left != null && right != null) return root; // p and q on different sides
    return left != null ? left : right;
}

// BST — use BST property to navigate
TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
    if (p.val < root.val && q.val < root.val) return lcaBST(root.left, p, q);
    if (p.val > root.val && q.val > root.val) return lcaBST(root.right, p, q);
    return root; // split point = LCA
}
```

---

## Path Sum Pattern

```java
boolean hasPathSum(TreeNode node, int remaining) {
    if (node == null) return false;
    remaining -= node.val;
    if (node.left == null && node.right == null) return remaining == 0; // leaf check
    return hasPathSum(node.left, remaining) || hasPathSum(node.right, remaining);
}
```

---

## Invert / Mirror a Tree

```java
TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    TreeNode tmp  = root.left;
    root.left     = invertTree(root.right);
    root.right    = invertTree(tmp);
    return root;
}
```

---

## Complexity Summary

| Operation | Balanced tree | Skewed tree (worst) |
|-----------|--------------|---------------------|
| Any DFS traversal | O(n) time, O(log n) space | O(n) space |
| BFS level-order | O(n) time, O(w) space | O(n) space |
| BST search / insert | O(log n) | O(n) |
| BST delete | O(log n) | O(n) |
| Height computation | O(n) | O(n) |

`h` = height, `w` = max width, `n` = number of nodes.

---

## Pattern → Technique

| Problem type | Technique |
|-------------|-----------|
| Max/min depth | Bottom-up DFS |
| Path sum | Top-down DFS with running sum |
| Diameter / max path | Bottom-up, track global max |
| LCA | Post-order DFS |
| Level-by-level output | BFS with level size loop |
| Serialize / deserialize | Preorder DFS |
| Validate BST | DFS with min/max range |
| Invert / mirror | Postorder swap |
| Balanced check | Bottom-up — return -1 on imbalance |
| Count nodes | Recursive count left + right + 1 |

---

## Edge Cases
- `null` root → handle first; return 0 / true / null
- Single node → it is both root and leaf; height = 1
- Skewed tree → height = n; risk of stack overflow on very deep recursion
- BST validation → use `Long.MIN_VALUE` / `Long.MAX_VALUE` as initial bounds to handle `Integer.MIN_VALUE` node values
- Leaf node check → `node.left == null && node.right == null`
