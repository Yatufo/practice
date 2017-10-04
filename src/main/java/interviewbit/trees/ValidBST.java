package interviewbit.trees;


public class ValidBST {

    public static void main(String[] args) {
        ValidBST s = new ValidBST();

        TreeNode treeNode = new TreeNode(3, 2, 4, 1, 3, -1, -1, -1, -1, -1, -1);
        treeNode.print();
        int validBST = new ValidBST().isValidBST(treeNode);
        System.out.println(validBST);
    }


    public int isValidBST(TreeNode node) {
        return isInRange(node, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }


    private boolean isInRange(TreeNode node, int min, int max) {
        if (node == null)
            return true;

        return  min < node.val && node.val < max &&
                isInRange(node.left, min, node.val)
                && isInRange(node.right, node.val, max);
    }

}
