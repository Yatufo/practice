package interviewbit.trees;


import java.util.LinkedList;
import java.util.Queue;

public class SymetricBinaryTree {

    public static void main(String[] args) {
        SymetricBinaryTree s = new SymetricBinaryTree();

        TreeNode treeNode = new TreeNode(
                1, 2, 2, 3, 4, 4, 3, 8, 7, 6, 5, 5, 6, 7, 9
        );
        treeNode.print();
        int balanced = new SymetricBinaryTree().isSymmetric(treeNode);
        System.out.println(balanced);
    }

    public int isSymmetric(TreeNode a) {
        if (a == null) {
            return 1;
        }

        Queue<TreeNode> children = new LinkedList<>(), parents;
        children.add(a.left);
        children.add(a.right);

        while (!children.isEmpty()) {
            parents = children;
            children = new LinkedList<>();
            while (parents.size() >= 2) {
                TreeNode first = parents.poll(), second = parents.poll();
                if (!isSameValue(first, second)) {
                    return 0;
                } else if (first != null && second != null) {
                    children.add(first.left);
                    children.add(second.right);
                    children.add(first.right);
                    children.add(second.left);
                }
            }
        }
        return 1;
    }

    private boolean isSameValue(TreeNode left, TreeNode right) {
        return left == right || (left != null && right != null && left.val == right.val);
    }

}