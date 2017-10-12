package interviewbit.trees;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InOrderPreOrder {

    public static void main(String[] args) {
        InOrderPreOrder s = new InOrderPreOrder();
        TreeNode treeNode = new InOrderPreOrder().buildTree(
                Arrays.asList(1,2,4,5,3),
                Arrays.asList(4,2,5,1,3));
       treeNode.print();

    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null;
        }

        List<Integer> inOrderLeft = Collections.emptyList(), preOrderLeft, inOrderRight, preOrderRight;

        Integer headValue = preorder.get(0);
        int middleIndex = inorder.indexOf(headValue);
        TreeNode head = new TreeNode(headValue);

        if (middleIndex > 0) {
            inOrderLeft = inorder.subList(0, middleIndex);
            preOrderLeft = preorder.subList(1, inOrderLeft.size() + 1);
            head.left = buildTree(preOrderLeft, inOrderLeft);
        }
        if (middleIndex < inorder.size() - 1) {
            inOrderRight = inorder.subList(middleIndex + 1, inorder.size());
            preOrderRight = preorder.subList(inOrderLeft.size() + 1, preorder.size());
            head.right = buildTree(preOrderRight, inOrderRight);
        }

        return head;
    }

}