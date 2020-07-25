import java.util.Iterator;

/**
 * Iterator class for LinkedArrayList class.
 * @param <E>
 */
public class ListIterator<E> implements Iterator<E> {

    Node<E> current;
    int currentNodeIndex;
    int currentIndex;

    /**
     *  Iterator Constructor
     * @param list
     */
    public ListIterator(List<E> list) {
        current = list.getHead();
        currentNodeIndex = 0;
        currentIndex = 0;
    }

    /**
     * @return returns true if list has next element
     */
    @Override
    public boolean hasNext() {
        if (currentNodeIndex < current.getSize() - 1 && currentNodeIndex >= 0)
            return true;
        else if (currentNodeIndex == current.getSize() - 1) {
            if (current.getNext() == null)
                return false;
            else
                return true;
        } else
            return false;

    }

    /**
     * @return returns true if list has previous element
     */
    boolean hasPrevious() {

        if (currentNodeIndex < current.getSize() && currentNodeIndex > 0)
            return true;
        else if (currentNodeIndex == 0) {
            if (current.getPrev() == null)
                return false;
            else
                return true;
        } else
            return false;
    }

    /**
     * @return Returns next element
     */
    @Override
    public E next() {
        currentIndex++;
        if (currentNodeIndex < current.getSize() - 1 && currentNodeIndex >= 0) {
            currentNodeIndex++;

            return current.getDataAt(currentNodeIndex);
        } else if (currentNodeIndex == current.getSize() - 1 && this.hasNext()) {
            current = current.getNext();
            currentNodeIndex = 0;
            return current.getDataAt(currentNodeIndex);
        } else
            return null;
    }

    /**
     * @return Returns previous element
     */
    E previous() {
        currentIndex--;
        if (currentNodeIndex < current.getSize() && currentNodeIndex > 0) {
            currentNodeIndex--;
            return current.getDataAt(currentNodeIndex);
        } else if (currentNodeIndex == 0 && this.hasPrevious()) {
            current = current.getPrev();
            currentNodeIndex = current.getSize() - 1;
            return current.getDataAt(currentNodeIndex);
        } else
            return null;
    }

    /**
     * @return returns next index
     */
    int nextIndex() {

        return currentIndex + 1;
    }


    /**
     * @return returns previous index
     */
    int previousIndex() {
        return currentIndex - 1;
    }

    /**
     * Adds the element to the current location
     * @param e
     */
    void add(E e) {
        if (current.getSize() < current.getCapacity())
            current.addElement(currentNodeIndex, e);
        else {
            Node<E> newNode = new Node<>(current, current.getPrev());
            if (current.getPrev() != null)
                current.getPrev().setNext(newNode);
            current.setPrev(newNode);

            newNode.addElement(e);
        }
    }

    /**
     * Removes element from current location
     */
    public void remove() {
        if (current.size == 1) {
            if (current.getNext() != null)
                current.getNext().setPrev(current.getPrev());
            if (current.getPrev() != null)
                current.getPrev().setNext(current.getNext());
        } else
            current.remove(currentNodeIndex);

    }

    /**
     * Sets elemt to current element
     * @param e
     */
    void set(E e) {
        System.out.println(currentNodeIndex);
        current.setDataAt(e, currentNodeIndex);
    }

}
