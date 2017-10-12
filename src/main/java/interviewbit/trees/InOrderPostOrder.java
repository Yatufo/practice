package interviewbit.trees;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InOrderPostOrder {

    public static void main(String[] args) {
        InOrderPostOrder s = new InOrderPostOrder();
        TreeNode treeNode = new InOrderPostOrder().buildTree(
                Arrays.asList(17, 12, 24, 13, 2, 22, 9, 20, 18, 23, 3, 15, 21, 10, 4, 11, 19, 14, 16, 7, 1, 5, 6, 8),
                Arrays.asList(17, 13, 2, 22, 24, 18, 20, 9, 15, 3, 11, 4, 10, 14, 16, 19, 1, 7, 21, 23, 12, 6, 8, 5));
        treeNode.print();

    }

    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (postorder.isEmpty()) {
            return null;
        }

        List<Integer> inOrderLeft = Collections.emptyList(), postOrderLeft, inOrderRight, postOrderRight;

        Integer headValue = postorder.get(postorder.size() - 1);
        int middle = inorder.indexOf(headValue);
        TreeNode head = new TreeNode(headValue);

        if (middle > 0) {
            inOrderLeft = inorder.subList(0, middle);
            postOrderLeft = postorder.subList(0, inOrderLeft.size());
            head.left = buildTree(inOrderLeft, postOrderLeft);
        }
        if (middle < inorder.size() - 1) {
            inOrderRight = inorder.subList(middle + 1, inorder.size());
            postOrderRight = postorder.subList(inOrderLeft.size(), postorder.size() - 1);
            head.right = buildTree(inOrderRight, postOrderRight);
        }

        return head;
    }

}