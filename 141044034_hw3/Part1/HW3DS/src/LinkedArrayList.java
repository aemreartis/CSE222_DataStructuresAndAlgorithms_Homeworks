public class LinkedArrayList<E> extends AbstractList<E> implements List<E> {
    Node<E> head, tail;

    LinkedArrayList() {
        head = new Node<E>();
        tail = head;
    }

    public ListIterator<E> iterator() {
        return new ListIterator<E>(this);
    }

    /**
     * Gets element from given index
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        int tempSize = 0;
        int i = 0;
        Node<E> current = head,temp=null;
        if(index>size()-1){
            System.out.println("Out of size");
            return null;
        }

        tempSize = current.getSize();

        while (tempSize - 1 < index || current == null) {

            current = current.getNext();
            tempSize += current.getSize();
        }
        if (current != null) {
            i = index - (tempSize - current.getSize());

            return current.getDataAt(i);
        } else
            return null;
    }

    /**
     * Sets element to given index
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        int tempSize = 0;

        if(index>size()-1){
            System.out.println("Out of size");
            return null;
        }

        int i = 0;
        Node<E> current = head;
        tempSize = current.getSize();
        while (tempSize - 1 < index || current == null) {
            current = current.getNext();
            tempSize += current.getSize();
        }
        if (current != null) {
            i = index - (tempSize - current.getSize());

            current.setDataAt(element, i);
            return current.getDataAt(i);
        } else
            return null;
    }

    /**
     * Adds elemnt to array.
     * @param element
     * @return
     */
    @Override
    public boolean add(E element) {
        Node<E> current = head,temp = null;

        while (current != null) {
            if (current.getSize() < current.getCapacity()) {
                current.addElement(element);
                return true;
            }
            if(current.getNext()==null)
                temp=current;

                current = current.getNext();
        }
        if (current == null) {
            Node<E> newNode = new Node<E>(temp.getNext(), temp);
            if(temp.getNext()!=null)
                temp.getNext().setPrev(temp);
            temp.setNext(newNode);
            newNode.addElement(element);
        }
        return true;
    }

    /**
     * Adds element given index
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        int tempSize = 0;
        if(index>size()-1){
            System.out.println("Out of size");
            return;
        }
        int i = 0;
        Node<E> current = head;
        tempSize = current.getSize();
        while (tempSize - 1 < index || current == null) {
            current = current.getNext();
            tempSize += current.getSize();
        }
        if (current != null) {
            i = index - (tempSize - current.getSize());

            if (current.getSize() < current.getCapacity()) {
                current.addElement(i,element);
            } else {
                Node<E> newNode = new Node<>(current, current.getPrev());
                current.getPrev().setNext(newNode);
                current.setPrev(newNode);
                newNode.addElement(element);
            }

        }
    }

    /**
     * Removes element from given index
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        int tempSize = 0;
        int i = 0;
        Node<E> current = head;
        if(index>size()-1){
            System.out.println("Out of size");
            return null;
        }
        tempSize = current.getSize();
        while (tempSize - 1 < index || current == null) {
            current = current.getNext();
            tempSize += current.getSize();
        }
        if (current != null) {
            i = index - (tempSize - current.getSize());
            E temp = current.remove(i);

            if (current.getSize() == 0) {
                current.getNext().setPrev(current.getPrev());
                current.getPrev().setNext(current.getNext());
                current = null;
            }
            return temp;
        } else
            return null;
    }

    /**
     * Removes given element from the list
     * @param element
     * @return
     */
    @Override
    public boolean remove(E element) {
        Node<E> current = getHead();

        while (current != null) {
            if (current.hasElement(element)) {
                current.remove(element);
                if (current.getSize() == 0) {
                    current.getNext().setPrev(current.getPrev());
                    current.getPrev().setNext(current.getNext());
                    current = null;
                }
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    /**
     * @return Returns true if list is empty
     */
    @Override
    public boolean isEmpty() {
        if(size()>0)
            return false;
        else
            return true;
    }

    /**
     * @param element
     * @return Returns true if list contains given element
     */
    @Override
    public boolean contains(E element) {
        Node<E> current = head;
        while (current != null) {
            if (current.hasElement(element))
                return true;
            current = current.getNext();
        }
        return false;
    }

    /**
     * @return Returns size of list.
     */
    @Override
    public int size() {
        Node<E> current = head;
        int size = 0;
        while (current != null) {
            size += current.getSize();
            current = current.getNext();
        }
        return size;
    }

    /**
     * @return Returns head node of list
     */
    @Override
    public Node<E> getHead() {
        Node<E> temp = head;
        while (temp.getPrev() != null) {
            temp = temp.getPrev();
        }
        head = temp;
        return head;
    }

    /**
     * @return Returns last node of list.
     */
    @Override
    public Node<E> getTail() {
        Node<E> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        tail = temp;
        return tail;
    }

}
