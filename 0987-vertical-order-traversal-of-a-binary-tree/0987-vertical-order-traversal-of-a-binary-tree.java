/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    static class Pair {
        TreeNode node;
        int hd;
        int row;

        Pair(TreeNode node, int hd, int row) {
            this.node = node;
            this.hd = hd;
            this.row = row;
        }
    }

    static class NodeInfo {
        int value;
        int row;

        NodeInfo(int value, int row) {
            this.value = value;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, List<NodeInfo>> viewMap = new TreeMap<>();
        Queue<Pair> bfs = new LinkedList<>();

        bfs.add(new Pair(root, 0, 0));

        while (!bfs.isEmpty()) {

            Pair currNode = bfs.poll();

            int parenthd = currNode.hd;
            int currentRow = currNode.row;

            if (!viewMap.containsKey(parenthd)) {
                viewMap.put(parenthd, new ArrayList<>());
            }

            viewMap.get(parenthd).add(
                new NodeInfo(currNode.node.val, currentRow)
            );

            // LEFT CHILD
            if (currNode.node.left != null) {

                TreeNode nodes = currNode.node.left;

                bfs.add(
                    new Pair(nodes, parenthd - 1, currentRow + 1)
                );
            }

            // RIGHT CHILD
            if (currNode.node.right != null) {

                TreeNode nodes = currNode.node.right;

                bfs.add(
                    new Pair(nodes, parenthd + 1, currentRow + 1)
                );
            }
        }

        // Sort each column:
        // 1. Row ascending
        // 2. If row same → value ascending

        for (List<NodeInfo> list : viewMap.values()) {

            list.sort((a, b) -> {
//  yha based on node data sort ho rha h comparator se
                if (a.row != b.row) {
                    return a.row - b.row;
                }
// yha based on depth sorting ho rhi h
                return a.value - b.value;
            });
        }

        // Convert NodeInfo lists into Integer lists

        List<List<Integer>> finalList = new ArrayList<>();

        for (List<NodeInfo> list : viewMap.values()) {

            List<Integer> column = new ArrayList<>();

            for (NodeInfo node : list) {
                column.add(node.value);
            }

            finalList.add(column);
        }

        return finalList;
    }
}