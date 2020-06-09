package com.scarlett.tree;

/**
 * @ClassName : BinaryTree
 * Description :
 * @Author : scarlett
 * @Date: 2020-06-07 16:28
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        // 测试，前序遍历
        System.out.println("先序遍历");
        binaryTree.preOrder();
        // 测试，后续遍历
        System.out.println("后序遍历");
        binaryTree.postOrder();

        // 先序遍历查找
        System.out.println("先序遍历查找");
        HeroNode resNode = binaryTree.preOrderSearch(2);
        if (resNode != null) {
            System.out.println("找到了。" + resNode.getName());
        } else {
            System.out.println("没找到噢。");
        }

        // 测试删除节点
        System.out.println("测试删除节点。");
        binaryTree.delNode(3);
        System.out.println("删除后");
        binaryTree.preOrder();
    }
}


class HeroNode {
    private int no;
    private String name;
    // 默认为null
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        // 先输出父节点
        System.out.println(this);
        // 递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        // 递归左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出父节点
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 先序查找
     * @param no 编号
     * @return 如果找到返回该节点，否则返回null
     */
    public HeroNode preOrderSearch(int no) {
        // 比较当前节点
        if (this.no == no) {
            return this;
        }
        // 判断当前左子节点是否为空，如果不为空，则递归先序查找
        // 如果左递归查找，找到节点，则返回
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        // 说明左子树找到
        if (resNode != null) {
            return resNode;
        }
        // 当前节点的右子节点是否为空，如果不为空，则继续向右递归先序查找
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode !=null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 递归删除节点
     * 如果删除的节点是叶子节点，则删除该节点
     * 如果删除的节点是非叶子节点，则删除该子树
     * @param no 编号
     */
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        // 向左子树递归删除
        if (this.left != null) {
            this.left.delNode(no);
        }
        // 向右子树递归删除
        if (this.right != null) {
            this.right.delNode(no);
        }
    }
}

class BinaryTree {

    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void delNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("空树，无法删除。");
        }
    }

    public void preOrder() {
        if (this.root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历。");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历。");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历。");
        }
    }

    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }
}