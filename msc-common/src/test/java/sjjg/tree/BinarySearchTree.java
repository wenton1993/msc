package sjjg.tree;

import org.apache.commons.lang3.RandomUtils;

/**
 * T, 泛型为 T
 * T extends Comparable, T 实现了 Comparable 接口
 * T extends Comparable<? super T>, 不知道
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private static class BinaryNode<T> {

        BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        T element;

        BinaryNode<T> left;

        BinaryNode<T> right;

    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T element) {
        root = insert(element, root);
    }

    private BinaryNode<T> insert(T element, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(element, null, null);
        }

        int compareResult = element.compareTo(node.element);

        if (compareResult < 0) {
            node.left = insert(element, node.left);
        } else if (compareResult == 0) {
            // do nothing
        } else {
            node.right = insert(element, node.right);
        }

        return node;
    }

    public BinaryNode<T> remove(T element) {
        return remove(element, root);
    }

    private BinaryNode<T> remove(T element, BinaryNode<T> node) {
        if (node == null) {
            return node;
        }

        int compareResult = element.compareTo(node.element);

        if (compareResult == 0) {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left != null && node.right == null) {
                // 只有左子树
                node = node.left;
            } else if (node.left == null && node.right != null) {
                // 只有右子树
                node.element = findMin(node.right).element;
                node.right = remove(node.element, node.right);
            } else {
                // 左右子树都存在
                node.element = findMin(node.right).element;
                node.right = remove(node.element, node.right);
            }
        } else if (compareResult < 0) {
            node.left = remove(element, node.left);
        } else {
            node.right = remove(element, node.right);
        }

        return node;
    }

    public boolean contain(T element) {
        return contain(element, root);
    }

    private boolean contain(T element, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }

        int c = node.element.compareTo(element);

        if (c < 0) {
            return contain(element, node.left);
        } else if (c == 0) {
            return true;
        } else {
            return contain(element, node.right);
        }
    }

    public T findMin() {
        if (root == null) {
            return null;
        }
        return findMin(root).element;
    }

    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    public T findMax() {
        if (root == null) {
            return null;
        }
        return findMax(root).element;
    }

    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        } else {
            return findMin(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        for (int i = 0; i < 10; i++) {
            tree.insert(RandomUtils.nextInt(1, 100));
        }
        System.out.println("End");
    }

}
