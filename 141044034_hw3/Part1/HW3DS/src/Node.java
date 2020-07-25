/**
 * Node class which keeps E type Data array
 * @param <E>
 */
class Node<E> {
    Node<E> next;
    Node<E> prev;

    E[] data;
    int size;
    int capacity;

    /**
     * No parameter Constructor
     */
    public Node() {
        next = null;
        prev = null;
        size = 0;
        this.capacity = 5;
        final E[] data = (E[]) new Object[capacity];
        this.data = data;
    }

    /**
     * Constructor with given next and previous nodes
     * @param nextValue
     * @param prevValue
     */
    public Node(Node nextValue, Node prevValue) {
        next = nextValue;
        prev = prevValue;
        size = 0;
        this.capacity = 5;
        final E[] data = (E[]) new Object[capacity];
        this.data = data;
    }

    /**
     * @return Returns size of array in the node.
     */
    public int getSize() {
        return size;
    }

    /**
     * @return Returns capacity of array in the node.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns data at given index in the array
     * @param index
     * @return
     */
    public E getDataAt(int index) {
        return data[index];
    }

    public void setDataAt(E dataValue, int index) {
        data[index] = dataValue;
    }

    /**
     * @return Returns next node.
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param nextValue Sets next node.
     */
    public void setNext(Node nextValue) {
        next = nextValue;
    }

    /**
     * @return Returns Previous node.
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * @param prevValue Sets previous Node.
     */
    public void setPrev(Node prevValue) {
        prev = prevValue;
    }

    /**
     * Adds element to the Nodes array.
     * @param element
     * @return
     */
    public boolean addElement(E element) {
        if (size != capacity) {
            data[size] = element;
            size++;
            return true;
        } else
            return false;
    }

    /**
     * Adds elemnt to the nodes array with given index.
     * @param index
     * @param element
     * @return
     */
    public boolean addElement(int index, E element) {

        size++;
        E temp,temp2;

        temp = data[index];
        for (int i = index+1; i < size; i++) {
                temp2=data[i];
                data[i] = temp;
                temp=temp2;
        }
        data[index] = element;
        return true;
    }

    /**
     * Removes given element
     * @param element
     * @return
     */
    public E remove(E element) {
        boolean found = false;
        E removedElement = null;
        for (int i = 0; i < size; i++) {
            if (element.equals(data[i]) ){
                found = true;
                removedElement = data[i];
            }
            if (found && i != size - 1) {
                data[i] = data[i + 1];
            }
        }
        size--;
        return removedElement;
    }

    /**
     * Removes element in the given index
     * @param index
     * @return
     */
    public E remove(int index) {
        E removedElement = data[index];

        for (int i = index; i < size; i++)
            if (i != size - 1)
                data[i] = data[i + 1];
        size--;
        return removedElement;
    }

    /**
     * Checks if given element exist in Nodes array.
     * @param element
     * @return
     */
    public boolean hasElement(E element) {

        for (int i = 0; i < size; i++)
            if (data[i].equals(element))
                return true;

        return false;
    }
}

