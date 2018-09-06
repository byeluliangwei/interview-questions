package cn.luliangwei.interview.questions.tree;

/*
 * 二叉树BinaryTree的数据结构
 */
public class TreeNode {

    public int val;
    //左节点
    public TreeNode left;
    //右节点
    public TreeNode right;
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode left(int val) {
        this.left = new TreeNode(val);
        return this.left;
    }
    
    public TreeNode right(int val) {
        this.right = new TreeNode(val);
        return this.right;
    }
}
