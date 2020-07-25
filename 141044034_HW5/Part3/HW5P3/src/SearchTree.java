/**
 * @param <E>
 */
public interface SearchTree<E> {
    /**
     * @param target
     * @return
     */
    E find(E target);

    /**
     * @param target
     * @return
     */
    E delete(E target);

    /**
     * @param item
     * @return
     */
    boolean add(E item);

    /**
     * @param target
     * @return
     */
    boolean contains(E target);

    /**
     * @param target
     * @return
     */
    boolean remove(E target);
}