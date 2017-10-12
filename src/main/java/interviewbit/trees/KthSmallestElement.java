package interviewbit.trees;


import java.util.*;

public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement s = new KthSmallestElement();
        TreeNode tree = new TreeNode(1, 2, 3, 4, 5);
        tree.print();
        new KthSmallestElement().kthsmallest(tree, 4);
    }

    public int kthsmallest(TreeNode root, int k) {
        int result = root.val;
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> elements = new Stack<>();
        elements.add(root);
        while(visited.size() < k){
            TreeNode current = elements.pop();

            boolean visitLeft = current.left != null && !visited.contains(current.left);
            boolean visitHead = !visitLeft && !visited.contains(current);
            boolean visitRight = current.right != null && !visited.contains(current.right);

            if (visitHead){
                result = current.val;
                visited.add(current);

                if (visitRight){
                    elements.add(current.right);
                }
            } else{
                elements.add(current);
            }

            if (visitLeft){
                elements.add(current.left);
            }
        }

        return result;
    }

}