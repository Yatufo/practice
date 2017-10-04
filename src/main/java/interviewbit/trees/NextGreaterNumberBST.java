package interviewbit.trees;

import interviewbit.linkedlist.ListNode;

import java.util.*;


public class NextGreaterNumberBST {

    public static void main(String[] args) {
        NextGreaterNumberBST s = new NextGreaterNumberBST();

        TreeNode treeNode = new TreeNode(15, 10,20, 1 );
        treeNode.print();
        new NextGreaterNumberBST().getSuccessor(treeNode, 1);
    }


    public TreeNode getSuccessor(TreeNode a, int min) {
        if (a == null){
            return a;
        }

        int max = Integer.MAX_VALUE;
        TreeNode successor = null;
        Set<TreeNode> visited = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(a);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.left == null || visited.contains(current.left)) {
                visited.add(current);
                if (min < current.val && current.val < max){
                    successor = current;
                    max = current.val;
                }
                if (current.right != null) {
                    stack.add(current.right);
                }
            } else {
                stack.add(current);
                stack.add(current.left);
            }
        }

        return successor;
    }


}
