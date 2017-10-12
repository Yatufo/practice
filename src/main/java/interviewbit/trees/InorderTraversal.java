package interviewbit.trees;


import java.util.*;

public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal s = new InorderTraversal();

        TreeNode treeNode = new TreeNode(1, 2, 3, 4, 5, -1, 7, -1, -1, 10, 11, 12, -1);
        treeNode.print();
        new InorderTraversal().inorderTraversal(treeNode);

    }

    public ArrayList<Integer> inorderTraversal(TreeNode node) {
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();
        List<TreeNode> visited = new ArrayList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            boolean visitLeft = current.left != null && !visited.contains(current.left);
            boolean visitRight = current.right != null && !visited.contains(current.right);
            boolean visitNode = !visitLeft && !visited.contains(current);

            if (visitNode) {
                visited.add(current);
                results.add(current.val);
            }

            if (visitLeft) {
                nodes.add(current);
                nodes.add(current.left);
            } else if (visitRight) {
                nodes.add(current.right);
            }
        }


        return results;
    }

}