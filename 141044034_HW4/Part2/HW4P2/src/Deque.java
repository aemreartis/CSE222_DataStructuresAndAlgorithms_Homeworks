/**
 * Deque class implentation to keep data
 * @param <E>
 */
public class Deque<E> implements IDeque<E> {
    private LinkedList<E> data;
    private LinkedList<E> removedData;


    /**
     * Constuctor
     */
    Deque() {
        data = new LinkedList<E>();
        removedData = new LinkedList<E>();
    }

    /**
     * @param o Adds element to head
     */
    @Override
    public void addFirst(Object o) {
        if (removedData.size() == 0)
            data.addFirst(new Node<E>(data.getHead(), null, (E) o));
        else {
            Node<E> temp = removedData.removeFirst();
            temp.setPrev(null);
            temp.setNext(data.getHead());
            temp.set((E) o);
            data.addFirst(temp);
        }
    }

    /**
     * @param o adds element to tail
     */
    @Override
    public void addLast(Object o) {
        if (removedData.size() == 0)
            data.addLast(new Node<E>(null, data.getTail(), (E) o));
        else {
            Node<E> temp = removedData.removeFirst();
            temp.setPrev(data.getTail());
            temp.setNext(null);
            temp.set((E) o);
            data.addLast(temp);
        }
    }

    /**
     * @return removes first element
     */
    @Override
    public Object removeFirst() {
        Node<E> temp = data.removeFirst();
        removedData.addLast(temp);
        return temp.getData();
    }

    /**
     * @return removes last element.
     */
    @Override
    public Object removeLast() {
        Node<E> temp = data.removeLast();
        removedData.addLast(temp);
        return temp.getData();
    }


    /**
     * @return returns head node.
     */
    @Override
    public Object getFirst() {
        if (data != null)
            return data.getHead();
        else
            return null;
    }

    /**
     * @return returns tail node
     */
    @Override
    public Object getLast() {

        if (data != null)
            return data.getTail();
        else
            return null;
    }

    /**
     * @return gets head element.
     */
    @Override
    public Object peekFirst() {

        if (data != null)
            return data.getHead().getData();
        else
            return null;
    }

    /**
     * @return gets tail element.
     */
    @Override
    public Object peekLast() {

        if (data != null)
            return data.getTail().getData();
        else
            return null;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        data = new LinkedList<E>();
        removedData = new LinkedList<E>();
    }

    /**
     * checks if given element exists in list.
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        Node<E> temp = data.getHead();
        while (temp != null) {
            if (temp.getData().equals(o))
                return true;
            temp=temp.next;
        }
        return false;
    }

    /**
     * @return returns size.
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * @return Checks list is empty or not.
     */
    @Override
    public boolean isEmpty() {
        if (data.size() == 0)
            return true;
        else
            return false;
    }

    /**
     * @return returns iterator
     */
    @Override
    public Iterator iterator() {
        return new DequeIterator<E>(this);
    }

}
