package leetcode129;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Original {

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

    public static void main(String[] args) {

        TreeNode tree1 = new TreeNode(4);
        tree1.left = new TreeNode(9);
        tree1.right = new TreeNode(0);
        tree1.left.left = new TreeNode(5);
        tree1.left.right = new TreeNode(1);
        System.out.println("tree1 ==>> " + getSumToRoot(tree1));

        TreeNode tree2 = new TreeNode(1);
        tree2.left = new TreeNode(2);
        tree2.right = new TreeNode(3);
        System.out.println("tree2 ==>> " + getSumToRoot(tree2));

    }

    public static class Entry{
        public TreeNode node;
        public int value;

        public Entry(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
    }

    public static int getSumToRoot(TreeNode root){

        int sum = 0;

        Queue<Entry> queue = new LinkedList<Entry>();
        queue.add(new Entry(root,  0));

        while(!queue.isEmpty()){
            Entry current = queue.poll();
            TreeNode node = current.node;
            int value = (10 *  current.value) + node.val ;

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
}
