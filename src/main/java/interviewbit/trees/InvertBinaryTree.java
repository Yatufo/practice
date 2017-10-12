package interviewbit.trees;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class InvertBinaryTree {

    public static void main(String[] args) {
        InvertBinaryTree s = new InvertBinaryTree();
        TreeNode tree = new TreeNode(1, 2, 3, 4, 5);
        tree.print();
        TreeNode inverted = new InvertBinaryTree().invertTree(tree);
        inverted.print();

    }

    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);
        }

        return  root;
    }
}