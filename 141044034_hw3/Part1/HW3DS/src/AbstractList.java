public abstract class AbstractList<E> implements List<E>{

    /**
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        return null;
    }

    /**
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        return null;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean add(E o) {
        return false;
    }

    /**
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {

    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean contains(E o) {
        return false;
    }

    /**
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        return null;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public boolean remove(E o) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return 0;
    }
}
