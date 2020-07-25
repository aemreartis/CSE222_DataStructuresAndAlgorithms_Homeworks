/**
 * Binary Search tree from coursebook
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E> {

    protected boolean addReturn;
    protected E deleteReturn;

    /**
     * calls recursive find method
     *
     * @param target
     * @return returns target data
     */
    public E find(E target) {
        return find(root, target);
    }

    /**
     * Finds data recursively
     *
     * @param localRoot
     * @param target
     * @return Returns target Data
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }

    /**
     * calls recursive add method.
     *
     * @param item
     * @return
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     * finds node to add and adds the new item.
     *
     * @param localRoot
     * @param item
     * @return
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Deletes target data
     *
     * @param target
     * @return
     */
    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }

    /**
     * Deletes target data.
     *
     * @param localRoot
     * @param item
     * @return
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                return localRoot.right;
            } else if (localRoot.right == null) {
                return localRoot.left;
            } else {
                if (localRoot.left.right == null) {
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }

    /**
     * @param parent
     * @return
     */
    private E findLargestChild(Node<E> parent) {
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    /**
     * @param target Remooves target element
     * @return
     */
    @Override
    public boolean remove(E target) {
        E temp =find(target);
        delete(temp);
        return true;
    }

    /**Checks if it contains target element
     * @param target
     * @return
     */
    @Override
    public boolean contains(E target) {
        if(find(target) !=null)
            return true;
        else
            return false;
    }

}