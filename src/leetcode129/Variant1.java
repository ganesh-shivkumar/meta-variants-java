package leetcode129;

import java.util.LinkedList;
import java.util.Queue;

public class Variant1 {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static class Entry{
        public TreeNode node;
        public int value;

        public Entry(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
    }

    public static int sumRootToLeaf(TreeNode root){
        if(root == null) return 0;

        int sum = 0;

        Queue<Entry> queue = new LinkedList<Entry>();
        queue.add(new Entry(root, 0));

        while(!queue.isEmpty()){
            Entry current = queue.poll();
            TreeNode node = current.node;
            int value = current.value;
            String nodeValStr = String.valueOf(node.val);
            for(int i=0; i< nodeValStr.length(); i++){
                value = value * 10;
            }
            value = value + node.val;

            if(node.left==null && node.right==null){
                sum = sum + value;
                continue;
            }

            if(node.left!=null){
                queue.add(new Entry(node.left, value));
            }
            if(node.right!=null){
                queue.add(new Entry(node.right, value));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(90);
        root1.right = new TreeNode(42);
        root1.right.left = new TreeNode(511);
        int expected1 = 1290 + 142511;
        int actual1 = sumRootToLeaf(root1);
        System.out.println("Test Case 1: Expected = " + expected1 + ", Actual = " + actual1);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(912);
        root2.left.left.left = new TreeNode(3);
        root2.left.left.right = new TreeNode(4);
        root2.right = new TreeNode(46);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(61);
        int expected2 = 129123 + 129124 + 1465 + 14661;
        int actual2 = sumRootToLeaf(root2);
        System.out.println("Test Case 2: Expected = " + expected2 + ", Actual = " + actual2);

        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        int expected3 = 12 + 13;
        int actual3 = sumRootToLeaf(root3);
        System.out.println("Test Case 3: Expected = " + expected3 + ", Actual = " + actual3);

        TreeNode root4 = new TreeNode(10);
        root4.left = new TreeNode(200);
        root4.right = new TreeNode(3000);
        int expected4 = 10200 + 103000;
        int actual4 = sumRootToLeaf(root4);
        System.out.println("Test Case 4: Expected = " + expected4 + ", Actual = " + actual4);

        TreeNode root5 = new TreeNode(10);
        root5.left = new TreeNode(0);
        root5.right = new TreeNode(0);
        int expected5 = 200;
        int actual5 = sumRootToLeaf(root5);
        System.out.println("Test Case 5: Expected = " + expected5 + ", Actual = " + actual5);

        TreeNode root6 = null;
        int expected6 = 0;
        int actual6 = sumRootToLeaf(root6);
        System.out.println("Test Case 6: Expected = " + expected6 + ", Actual = " + actual6);

    }
}
