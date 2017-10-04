package interviewbit.trees;

import javax.swing.text.html.Option;
import java.util.*;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }

    TreeNode(Integer... params) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(params));
        Queue<TreeNode> parents = new LinkedList<>(), children;
        this.val = queue.poll();
        parents.add(this);

        while (!queue.isEmpty()) {
            children = new LinkedList<>();
            while (!parents.isEmpty() && !queue.isEmpty()) {
                TreeNode parent = parents.poll();
                if(parent != null){
                    parent.left = getNextNode(queue);
                    parent.right = getNextNode(queue);
                    children.add(parent.left);
                    children.add(parent.right);
                }
            }
            parents = children;
        }

    }

    private TreeNode getNextNode(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            Integer value = queue.poll();
            return value > -1 ? new TreeNode(value) : null;
        }
        return null;
    }

    public void print() {
        Queue<TreeNode> parents = new LinkedList<>(), children;
        parents.add(this);
        TreeNode EMPTY = new TreeNode(-1);
        int level = 1;
        while (!parents.isEmpty()) {
            System.out.print("Level " + level + ":");
            children = new LinkedList<>();
            while (!parents.isEmpty()) {
                TreeNode parent = parents.poll();
                System.out.print(" " + parent.val);
                children.add(Optional.ofNullable(parent.left).orElse(EMPTY));
                children.add(Optional.ofNullable(parent.right).orElse(EMPTY));
            }
            if (!children.stream().allMatch(p -> p == EMPTY)){
                parents = children;
            }
            System.out.println("");
            level++;
        }
    }
}
