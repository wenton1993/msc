package sjjg.tree;

import org.apache.commons.lang3.RandomUtils;

public class AvlTree<T extends Comparable<? super T>> {

    private static final int ALLOWED_IMBALANCE = 1;

    private AvlNode<T> root;

    public AvlTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.height;
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    private AvlNode<T> insert(T element, AvlNode<T> node) {
        if (node == null) {
            return new AvlNode<>(element, null, null);
        }

        int compareResult = element.compareTo(node.element);

        if (compareResult < 0) {
            node.left = insert(element, node.left);
        } else if (compareResult == 0) {
            // do nothing
        } else {
            node.right = insert(element, node.right);
        }

        return balance(node);
    }

    /**
     * 左旋转-解决左超长
     * 旋转的目的是移动合适节点到根节点, 以达到平衡
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> node) {
        AvlNode<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        left.height = Math.max(height(left.left), left.height) + 1;
        return left;
    }

    /**
     * 右旋转-解决右超长
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> node) {
        AvlNode<T> right = node.right;
        node.right = right.left;
        right.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        right.height = Math.max(height(right.left), right.height) + 1;
        return right;
    }

    /**
     * 双旋转-解决左右超长
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> node) {
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    /**
     * 双旋转-解决右左超长
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> node) {
        node.right = rotateWithLeftChild(node.right);
        return rotateWithRightChild(node);
    }

    /**
     * 平衡
     */
    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) {
            return node;
        }

        if (height(node.left) - height(node.right) > ALLOWED_IMBALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.right) - height(node.left) > ALLOWED_IMBALANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private static class AvlNode<T> {

        T element;

        /**
         * 左子树
         */
        AvlNode<T> left;

        /**
         * 右子树
         */
        AvlNode<T> right;

        int height;// 似乎在 balance() 中更新

        AvlNode(T element) {
            this(element, null, null);
        }

        AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    public static void main(String[] args) {
        AvlTree<Integer> tree = new AvlTree<>();
        for (int i = 0; i < 20; i++) {
            tree.insert(RandomUtils.nextInt(1, 100));
        }
        System.out.println("End");
    }

}
