package interviewbit.trees;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PreorderTraversal {

    public static void main(String[] args) {
        PreorderTraversal s = new PreorderTraversal();

        TreeNode treeNode = new TreeNode(2, 7, 5, 2, 6, -1, 9, -1, -1, 5, 11, 4);
        treeNode.print();
        new PreorderTraversal().postorderTraversal(treeNode);

    }

    public ArrayList<Integer> postorderTraversal(TreeNode node) {
        Stack<TreeNode> nodes = new Stack<>();
        ArrayList<Integer> results = new ArrayList<>();
        nodes.add(node);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.pop();
            if(current != null){
                results.add(current.val);
                nodes.add(current.right);
                nodes.add(current.left);
            }
        }


        return results;
    }

}