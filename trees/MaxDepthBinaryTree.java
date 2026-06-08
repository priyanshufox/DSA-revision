package trees;


public class MaxDepthBinaryTree {
    
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return Integer.max(maxLeft,maxRight)+1;
    }

    public static void main(String[] args) {
        MaxDepthBinaryTree mdbt = new MaxDepthBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(mdbt.maxDepth(root)); // Output: 3
    }

    
}
