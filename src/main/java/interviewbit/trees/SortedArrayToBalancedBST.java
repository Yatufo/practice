package interviewbit.trees;


import java.util.*;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        SortedArrayToBalancedBST s = new SortedArrayToBalancedBST();

        TreeNode treeNode = new SortedArrayToBalancedBST().sortedArrayToBST(Arrays.asList(1,2,3,4,5,6));
        treeNode.print();

    }
    public TreeNode sortedArrayToBST(final List<Integer> sorted) {
        int middleIndex = (sorted.size())/ 2;
        TreeNode root = new TreeNode(sorted.get(middleIndex));
        if(middleIndex > 0){
            root.left = sortedArrayToBST(sorted.subList(0, middleIndex));
        }
        if(middleIndex < sorted.size() - 1) {
            root.right = sortedArrayToBST(sorted.subList(middleIndex + 1, sorted.size()));
        }

        return root;
    }


}