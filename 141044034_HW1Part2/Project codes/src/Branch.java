import java.util.ArrayList;
import java.util.BitSet;

/**
 * This class keeps branch data and methods.
 */
public class Branch {
    protected ArrayList<BranchEmployee> employeeList;
    protected ArrayList<TransportationPersonnel> transportationPersonnelList;
    protected ArrayList<Customer> customerList;
    private String branchName;


    /**
     * @param branchName Sets name of branches.
     */
    public Branch(String branchName) {
        this.branchName=branchName;
        transportationPersonnelList = new ArrayList<TransportationPersonnel>();
        employeeList = new ArrayList<BranchEmployee>();
        customerList = new ArrayList<Customer>();
    }

    /**
     * @return returns branch name.
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets branch name
     * @param branchName
     */
    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /**
     * Adds branch employee to employee list.
     * @param newEmployee
     */
    public void addBranchEmployee(BranchEmployee newEmployee) {
        employeeList.add(newEmployee);
    }

    /**
     * Prints list of employees.
     */
    public void printEmployees() {
        for(int i =0;i<employeeList.size();i++)
            System.out.println( (i+1)+"-" +employeeList.get(i).getFullName());
    }

    /**
     * Removes branch employee.
     * @param branchEmployeeID
     * @return Returns removed employee.
     */
    public BranchEmployee removeEmployee(int branchEmployeeID) {
        return employeeList.remove(branchEmployeeID);
    }

    /**
     * Adds transportation personnel to transportation personnel list.
     * @param newTransportationPersonnel
     */
    public void addTransportationPersonnel(TransportationPersonnel newTransportationPersonnel) {
        transportationPersonnelList.add(newTransportationPersonnel);
    }

    /**
     * Prints list of transportation personnel.
     */
    public void printTransportationPersonnels() {
        for(int i =0;i<transportationPersonnelList.size();i++)
            System.out.println( (i+1)+"-" +transportationPersonnelList.get(i).getFullName());
    }

    /**
     * Removes transportation personnels.
     * @param transportationPersonnelID
     * @return Returns removed personnels.
     */
    public TransportationPersonnel removeTransportationPersonnel(int transportationPersonnelID) {
        return transportationPersonnelList.remove(transportationPersonnelID);
    }

    /**
     * @return Returns list of customers.
     */
    public ArrayList<Customer> getCustomers() {
        return customerList;
    }

    /**
     * Prints list of customers.
     */
    public void printCustomers() {
        for(int i =0;i< customerList.size();i++)
            System.out.println( (i+1)+"-" +customerList.get(i).getFullName());

    }

    /**
     * @param i
     * @return Returns nth customer.
     */
    public Customer getCustomer(int i) {
        return customerList.get(i);
    }
}
