package trees;

public class BalancedBinaryTree {
    public int height(TreeNode root){
        if(root==null) return 0;
        return 1+Integer.max(height(root.left),height(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right))>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }
    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(bbt.isBalanced(root)); // Output: true
    }
}
