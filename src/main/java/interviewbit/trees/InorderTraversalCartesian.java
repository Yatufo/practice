package interviewbit.trees;


import java.util.*;

public class InorderTraversalCartesian {

    public static void main(String[] args) {
        InorderTraversalCartesian s = new InorderTraversalCartesian();

        TreeNode treeNode = new InorderTraversalCartesian().buildTree(Arrays.asList(5,6,1,2,4,3,7));
        treeNode.print();

    }
    public TreeNode buildTreeFromQueue(int max, Stack<Integer> stack) {
        TreeNode current = new TreeNode(stack.pop());
        while (!stack.isEmpty()){
            TreeNode next = new TreeNode(stack.pop());

            if (current.val < next.val){
                if (next.val < max){
                    next.left = current;
                    current = next;
                }else {
                    stack.add(next.val);
                    return current;
                }
            }else{
                stack.add(next.val);
                current.right = buildTreeFromQueue(current.val, stack);
            }
        }

        return current;
    }
    public TreeNode buildTree(List<Integer> elements) {
        if (elements.isEmpty())
            return null;

        Stack<Integer> stack = new Stack<>();
        for (int i = elements.size() - 1; i >= 0; i--) {
            stack.add(elements.get(i));
        }
        return buildTreeFromQueue(Integer.MAX_VALUE, stack);
    }


}