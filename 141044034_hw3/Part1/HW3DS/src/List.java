public interface List <E>{


    /**
     * Returns element at given index
     * @param index
     * @return
     */
    public E get(int index) ;

    /**
     * Sets Element in given index
     * @param index
     * @param element
     * @return
     */
    E set(int index, E element);

    /**
     * Adds element to list
     * @param e
     * @return
     */
    public boolean add(E e);

    /**
     * Adds element to given index
     * @param index
     * @param element
     */
    public void add(int index, E element);

    /**
     * Checks  list if it is empty.
     * @return
     */
    boolean isEmpty();

    /**
     * Checks list if it has given element
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * Removes element from given index.
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * Removes given element.
     * @param e
     * @return
     */
    boolean remove(E e);

    /**
     * @return Returns size of List
     */
    public int size();

    /**
     * @return Returns Head of list
     */
    Node<E> getHead();

    /**
     * @return Returns Last node of List
     */
    Node<E> getTail();

}
