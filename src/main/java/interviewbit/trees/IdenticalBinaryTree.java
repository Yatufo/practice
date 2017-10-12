package interviewbit.trees;


public class IdenticalBinaryTree {

    public static void main(String[] args) {
        IdenticalBinaryTree s = new IdenticalBinaryTree();

        TreeNode treeNode = new TreeNode(

                17, 1, 2, 3, 4, 5, -1, 6, 7, 8, -1, -1, -1, -1, -1, -1, -1, -1
        );
        treeNode.print();
        int balanced = new IdenticalBinaryTree().isSameTree(null, null);
        System.out.println(balanced);
    }

    public int isSameTree(TreeNode a, TreeNode b) {
        return isSameTreeBoolean(a,b) ? 1 : 0;
    }

    private boolean isSameTreeBoolean(TreeNode a, TreeNode b) {
        if( a != null && b != null){
            return a.val == b.val && isSameTreeBoolean(a.left, b.left) && isSameTreeBoolean(a.right, b.right);
        }

        return a == b;
    }

}