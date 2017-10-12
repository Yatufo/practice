package interviewbit.trees;


import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        VerticalOrderTraversal s = new VerticalOrderTraversal();

        TreeNode treeNode = new TreeNode(460, 3871, 4698, 8399, 504, 4421, 7515, -1, 4167, 5727, -1, -1, 3096, 434, 7389, 2667, 5661, 1969, 7815, 4292, 3006, 9750, 6693, -1, 6906, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        treeNode.print();
        new VerticalOrderTraversal().verticalOrderTraversal(treeNode);

    }

    class NodeColumn {
        int column = 0;
        TreeNode node;

        public NodeColumn(TreeNode n, int c) {
            this.node = n;
            this.column = c;
        }
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<NodeColumn> children = new LinkedList<>(), parents;
        children.add(new NodeColumn(node, 0));

        while (!children.isEmpty()) {
            parents = children;
            children = new LinkedList<>();

            while (!parents.isEmpty()) {
                NodeColumn parent = parents.poll();
                TreeNode current = parent.node;
                if (current != null) {
                    int column = parent.column;
                    ArrayList<Integer> elements = map.getOrDefault(column, new ArrayList<>());
                    elements.add(current.val);
                    map.put(column, elements);
                    children.add(new NodeColumn(current.left, column - 1));
                    children.add(new NodeColumn(current.right, column + 1));
                }

            }
        }

        map.keySet().stream().sorted().forEach(column -> result.add(map.get(column)));

        return result;
    }

}
