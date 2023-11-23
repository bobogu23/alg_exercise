package com.alg.exercise.new20231009hot100.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 解法 1：
 * <p>
 * 找到 p,q各自的祖先， node.parent
 * 怎么找 p,q各自的祖先。从root节点开始递归遍历每个节点，并且用列表记录下来，
 * 如果有条路径能到达节点p，则列表上的节点是p的祖先。
 * 如果有条路径能到达节点q，则列表上的节点是q的祖先。
 * 然后求两个列表中 距离p,q 最近的节点pnext,qnext。条件是 pnext.val != qnext.val
 * 或者pnext == null || qnext ==null
 * <p>
 * 解法2：
 * root节点是节点p的祖先定义：p在root的（左/右）子树中，或者 root ==p
 * 最近公共祖先：假设root是p,q的最近公共祖先，则 root.left ,root.right 都不是p,q的公共祖先。
 * root是p,q的公共祖先的情况
 * 1）p,q 在root的子树中，分别在root的左右两侧子树中
 * 2) p==root,q在root的（左/右） 子树中
 * 3) q==root,p在root的（左/右） 子树中
 *
 * @author ben.gu
 */
public class LowestCommonAncestor_14 {
    public static void main(String[] args) {
        LowestCommonAncestor_14 la = new LowestCommonAncestor_14();
        TreeNode root = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        root.left = n5;
        TreeNode n1 = new TreeNode(1);
        root.right = n1;

        TreeNode n6 = new TreeNode(6);
        TreeNode n2 = new TreeNode(2);
        n5.left = n6;
        n5.right = n2;

        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4);
        n2.left = n7;
        n2.right = n4;

        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        n1.left = n0;
        n1.right = n8;

        TreeNode treeNode = la.lowestCommonAncestor(root, n5, n4);
        System.err.println(treeNode.val);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件，root 等于 null[越过了叶子节点]  或者p,q等于root
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        //在左右子树中寻找p,q
        TreeNode l = lowestCommonAncestor2(root.left, p, q);
        TreeNode r = lowestCommonAncestor2(root.right, p, q);
        //左右子树中都没找到p
        if (l == null && r == null) {
            return null;
        }
        //在左右子树中分别找到了p,q,说明root是最近的公共祖先
        if (l != null && r != null) {
            return root;
        }
        //在左/右子树中找到了p||q, 或者p,q 都在左/右 子树中
        return l == null ? r : l;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestor(root, p);
        tmp.clear();
        ancestor(root, q);
        List<TreeNode> traceP = res.get(0);
        List<TreeNode> traceQ = res.get(1);
        Iterator<TreeNode> iteratorp = traceP.iterator();
        Iterator<TreeNode> iteratorq = traceQ.iterator();
        TreeNode pre = null;
        while (iteratorp.hasNext() && iteratorq.hasNext()) {
            TreeNode pnext = iteratorp.next();
            TreeNode qnext = iteratorq.next();
            if (pnext == null || qnext == null) {
                return pre;
            }
            if (pnext.val != qnext.val) {
                return pre;
            }
            pre = pnext;
        }
        return pre;
    }

    private List<List<TreeNode>> res = new ArrayList<>();
    private LinkedList<TreeNode> tmp = new LinkedList<>();

    //回溯，找到节点p的路径
    private void ancestor(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        if (root.val == p.val) {
            tmp.add(root);
            res.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(root);
        ancestor(root.left, p);
        ancestor(root.right, p);
        tmp.removeLast();
    }


}
