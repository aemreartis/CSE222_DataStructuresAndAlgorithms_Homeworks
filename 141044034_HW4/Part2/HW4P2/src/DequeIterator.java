public class DequeIterator<E> implements Iterator<E>{
    Node<E> iter;

    /**
     * @param deque
     */
    DequeIterator(Deque deque){
        iter= (Node<E>) deque.getFirst();
        Deque tmp =deque;
    }

    /**
     * @return returns next element.
     */
    @Override
    public Object next() {
        iter=iter.next;
        return iter.getData();
    }

    /**
     * @return checks next nodes existance
     */
    @Override
    public boolean hasNext() {
        if (iter.getNext()==null)
            return false;
        else
            return true;
    }


    /**
     * @return returns previous element.
     */
    public Object previous() {
        iter=iter.getPrev();
        return iter.getData();
    }

    /**
     * @return Checks previous nodes existance
     */
    public boolean hasPrevious() {

        if (iter.getPrev()==null)
            return false;
        else
            return true;
    }


    /**
     * @return Removes current node and returns element
     */
    @Override
    public Object remove() {
        Node<E> temp =iter;
        if(iter.getNext()!=null)
            iter.getNext().setPrev(iter.getPrev());
        if(iter.getPrev()!=null)
            iter.getPrev().setNext(iter.getNext());


        iter=iter.getNext();

        return temp.getData();
    }
}
