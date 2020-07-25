/**
 * Class to keep Age data.
 */
public class AgeData implements Comparable{
    private Integer age;
    private Integer numberOFPeople;

    /**
     * @param age
     */
    AgeData(Integer age){
        numberOFPeople=0;
        this.age=age;
    }

    /**
     * @return Returns number of People at that age.
     */
    public Integer getNumberOFPeople() {
        return numberOFPeople;
    }

    /**
     * @return returns Age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age Sets the age.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Increases number of people
     */
    public void increaseNumOfPeople() {
        numberOFPeople++;
    }

    /**
     * Decreases number of people.
     */
    public void decreaseNumOfPeople() {
        numberOFPeople--;
    }

    /**
     * Compares object with given object.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return age.compareTo( ((AgeData)o).getAge());
    }

    /**
     * @return Returns age and number of people as string.
     */
    @Override
    public String toString() {
        return age.toString()+"-"+numberOFPeople.toString();
    }
}
