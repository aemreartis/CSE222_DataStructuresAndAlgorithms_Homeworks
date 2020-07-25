/**
 * AgeSearchTree to keep AgeData
 * @param <E>
 */
public class AgeSearchTree<E> extends BinarySearchTree {
    /**
     * Adds object to the tree
     * @param item
     * @return
     */
    @Override
    public boolean add(Object item) {
        AgeData temp = (AgeData) item;
        AgeData isExist = find(temp);

        if (isExist != null)
            isExist.increaseNumOfPeople();
        else {
            super.add(temp);
            temp.increaseNumOfPeople();
        }
        return addReturn;
    }

    /**
     * Adds object to the tree
     * @param item
     * @return
     */
    public boolean add(AgeData item){
        return add((Object)item);
    }

    /**
     * Removes object from tree
     * @param target
     * @return
     */
    @Override
    public boolean remove(Object target) {

        AgeData temp = (AgeData) target;
        AgeData isExist = (AgeData) find(temp);

        if (isExist != null) {
            if(isExist.getNumberOFPeople()> 1 )
                isExist.decreaseNumOfPeople();
            else
                super.delete(isExist);

        } else {
            System.out.println("Object not exist");
            return false;
        }

        return true;
    }

    /**
     * Removes object from tree
     * @param item
     * @return
     */
    public boolean remove(AgeData item){
        return remove((Object)item);
    }


    /**
     *  Finds and returns object
     * @param target
     * @return
     */
    @Override
    public Comparable find(Comparable target) {
        return super.find(target);
    }

    /**
     * Finds and returns object
     * @param target
     * @return
     */
    public AgeData find(AgeData target){

    return (AgeData) super.find(target);
    }

    /**
     * Finds and returns object
     * @param target
     * @return
     */
    @Override
    public Object find(Object target) {
        return super.find((Comparable) target);
    }

    /**
     * Calls binarysearch tree toString method.
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Finds number of people who younger than given age.
     * @param age
     * @return
     */
    public int youngerThan(Integer age){
        return youngerThan(root,new AgeData(age));
    }

    /**
     * Finds number of people who younger than given age.
     * @param localRoot
     * @param target
     * @return
     */
    private int youngerThan(Node<E> localRoot, AgeData target) {
        if (localRoot == null)
            return 0;
        int compResult = target.compareTo(localRoot.data);

         if (compResult > 0) {

             return youngerThan(localRoot.left, target)+((AgeData) localRoot.data).getNumberOFPeople();
         }
         else{
            return youngerThan(localRoot.right, target);
        }
    }

    /**
     * Finds number of people who older than given age.
     * @param age
     * @return
     */
    public int olderThan(Integer age){
        return olderThan(root,new AgeData(age));
    }

    /**
     * Finds number of people who older than given age.
     * @param localRoot
     * @param target
     * @return
     */
    public int olderThan(Node<E> localRoot, AgeData target){
        if (localRoot == null)
            return 0;
        int compResult = target.compareTo(localRoot.data);

        if (compResult < 0) {

            return olderThan(localRoot.left, target)+((AgeData) localRoot.data).getNumberOFPeople();
        }
        else{
            return olderThan(localRoot.right, target);
        }

    }



}
