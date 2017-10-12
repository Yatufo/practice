package interviewbit.trees;


public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree s = new BalancedBinaryTree();

        TreeNode treeNode = new TreeNode(

                17, 1, 2, 3, 4, 5, -1, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1
        );
        treeNode.print();
        int balanced = new BalancedBinaryTree().isBalanced(treeNode);
        System.out.println(balanced);
    }

    public int isBalanced(TreeNode node) {
        return IsBalancedBoolean(node) ? 1 : 0;
    }

    private boolean IsBalancedBoolean(TreeNode node) {
        if (node == null){
            return true;
        }

        boolean nodeIsBalanced = Math.abs(depth(node.left) - depth(node.right)) < 2;
        return nodeIsBalanced && IsBalancedBoolean(node.right) && IsBalancedBoolean(node.left);
    }

    private int depth(TreeNode node) {
        if (node == null){
            return 0;
        }
        return node.left == null && node.right == null ? 1 : 2;
    }

}