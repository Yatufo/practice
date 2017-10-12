package interviewbit.trees;


import java.util.*;

public class PostorderTraversal {

    public static void main(String[] args) {
        PostorderTraversal s = new PostorderTraversal();

        TreeNode treeNode = new TreeNode(1,2,3,4,5);
        treeNode.print();
        new PostorderTraversal().postorderTraversal(treeNode);

    }

    public ArrayList<Integer> postorderTraversal(TreeNode node) {
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            boolean visitLeft = current.left != null && !visited.contains(current.left);
            boolean visitRight = !visitLeft && current.right != null && !visited.contains(current.right);
            boolean visitNode =  !visitLeft && !visitRight && !visited.contains(current);

            if (visitLeft) {
                nodes.add(current);
                nodes.add(current.left);
            } else if (visitRight) {
                nodes.add(current);
                nodes.add(current.right);
            } else if(visitNode){
                visited.add(current);
                results.add(current.val);
            }
        }


        return results;
    }

}