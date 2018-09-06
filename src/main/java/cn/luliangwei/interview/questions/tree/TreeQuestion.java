package cn.luliangwei.interview.questions.tree;

/**
 * 
 * Tree 相关的题型.
 * </p>
 *
 * @author luliangwei
 */
public class TreeQuestion {

    /**
     * <1>二叉树
     * 
     * <pre>
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如
     * 前序遍历序列{1,2,4,7,3,5,6,8}和
     * 中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * </pre>
     * 
     * 结果： 运行时间：338ms 占用内存：22804K
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] center) {
        if (pre.length != center.length) {
            return null;
        }
        return buildTree(pre, 0, pre.length - 1, center, 0, center.length - 1);
    }

    // 递归构建
    private static TreeNode buildTree(int[] pre, int startpre, int endpre, int[] center, int startcenter,
            int endcenter) {
        if (startpre > endpre || startcenter > endcenter) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startpre]);
        for (int i = startcenter; i < center.length; i++) {
            if (pre[startpre] == center[i]) {
                root.left = buildTree(pre, startpre + 1, startpre + i - startcenter, center, startcenter, i - 1);
                root.right = buildTree(pre, i - startcenter + startpre + 1, endpre, center, i + 1, endcenter);
            }
        }
        return root;
    }

}
