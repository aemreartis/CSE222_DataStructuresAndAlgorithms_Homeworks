import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class keeps branch employee information and methods.
 */
public class BranchEmployee extends AbstractUser {
    ArrayList<AbstractUser> userList;
    Branch employeeBranch;

    /**
     * @param username Username
     * @param password Password
     * @param fullName Fullname
     * @param employeeBranch Branch of employee
     * @param userList List of user
     */
    public BranchEmployee(String username, String password, String fullName, Branch employeeBranch, ArrayList<AbstractUser> userList) {
        super(username, password, fullName);
        this.employeeBranch = employeeBranch;
        this.userList = userList;
        inputScanner = new Scanner(System.in);
    }

    /**
     * Shows branch employee panel.
     */
    @Override
    public void ShowPanel() {
        while (true) {
            System.out.println("1-Edit Information\n2-Add Customer\n3-Remove Customer");
            System.out.println("4-Return Main Menu");
            try {
                panelAction = inputScanner.nextInt();
            } catch (InputMismatchException x) {
                System.out.println("Wrong input type");
                panelAction = 5;
            }
            inputScanner.nextLine();
            switch (panelAction) {
                case 1:
                    if (employeeBranch.getCustomers().size() == 0)
                        System.out.println("No customer to edit!");
                    else {
                        editInformation();
                    }
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    removeCustomer();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Unknown command");
            }
            if (panelAction == 4)
                break;
        }
    }

    /**
     * Removes Customer from list of customers.
     */
    private void removeCustomer() {
        if (employeeBranch.getCustomers().size() == 0)
            System.out.println("No customer to remove!");
        else {
            int nthShipment;
            Customer oldCustomer;
            System.out.println("Chose customer to remove:");
            employeeBranch.printCustomers();
            try {
                nthShipment = inputScanner.nextInt();
                if (nthShipment > employeeBranch.customerList.size() || nthShipment < 1)
                    throw new InputMismatchException("This customer doesn't exist.");
                oldCustomer = employeeBranch.getCustomer(nthShipment - 1);
                userList.remove(oldCustomer);
                employeeBranch.getCustomers().remove(oldCustomer);
                System.out.println("Customer removed!");
            } catch (InputMismatchException x) {
                System.out.println(x);
            }
        }

    }

    /**
     * Adds customer to customer list.
     */
    private void addCustomer() {
        String sender, receiver, address, status = "in branch";
        Customer newCustomer;
        System.out.println("Sender:");
        sender = inputScanner.nextLine();

        System.out.println("Receiver:");
        receiver = inputScanner.nextLine();

        System.out.println("Adress:");
        address = inputScanner.nextLine();

        Shipment newShipment = new Shipment(sender, receiver, status, address);
        newCustomer = new Customer(sender, sender, sender, newShipment, userList);
        userList.add(newCustomer);
        employeeBranch.customerList.add(newCustomer);
        System.out.println("New customer added, tracking number is:" + (newShipment.getShipmentId()));

    }

    /**
     * Edits status of shipments.
     */
    private void editInformation() {
        int nthShipment;
        String newStatus;
        Customer customer;

        System.out.println("Chose Customer to Edit status:");
        employeeBranch.printCustomers();
        try {
            nthShipment = inputScanner.nextInt();
            inputScanner.nextLine();
            if(employeeBranch.customerList.size()<nthShipment || nthShipment<1)
                throw new InputMismatchException("This customer doesn't exist");
            System.out.println("Edit status:");
            newStatus = inputScanner.nextLine();
            customer = employeeBranch.getCustomer(nthShipment - 1);
            customer.setStatus(newStatus);
        } catch (InputMismatchException x) {
            System.out.println(x);
        }
    }

}
