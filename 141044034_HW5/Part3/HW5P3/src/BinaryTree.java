import java.util.Scanner;
import java.io.Serializable;

/**
 * Binary tree class implementation from coursebook.
 * @param <E>
 */
public class BinaryTree<E> implements Serializable {
    /**
     * Inner Node class to keep data
     * @param <E>
     */
    protected static class Node<E> implements Serializable {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        /**
         * @param data
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        /**
         * Returns data as string
         * @return
         */
        public String toString () {
            return data.toString();
        }
    }

    protected Node<E> root;

    /**
     *
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * @param root
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * @param data
     * @param leftTree
     * @param rightTree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }
    }

    /**
     * @return
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        }
        else {
            return null;
        }
    }

    /**
     * @return
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        }
        else {
            return null;
        }
    }

    /**
     * @return
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /**
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root, 1, sb);
        return sb.toString();
    }

    /**
     * @param node
     * @param depth
     * @param sb
     */
    private void toString(Node<E> node, int depth, StringBuilder sb) {
        int i;
        for (i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        }
        else {
            sb.append(node.toString());
            sb.append("\n");
            toString(node.left, depth + 1, sb);
            toString(node.right, depth + 1, sb);
        }
    }

    /**
     * @param scan
     * @return
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        String data = scan.nextLine().trim();
        if (data.equals("null")) {
            return null;
        }
        else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);

        }
    }

}