import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class keeps Customer data and methods.
 */
public class Customer extends AbstractUser {
    private Shipment shipment;
    private ArrayList<Customer> customerList;

    /**
     * @param username Username
     * @param password Password
     * @param fullName Fullname
     * @param shipment Shipment of customer
     * @param userList List of users.
     */
    public Customer(String username, String password, String fullName, Shipment shipment, ArrayList<AbstractUser> userList) {
        super(username, password, fullName);
        this.shipment = shipment;
        inputScanner = new Scanner(System.in);
        customerList = new ArrayList<Customer>();
        for (int i = 0; i < userList.size(); i++)
            if (userList.get(i) instanceof Customer)
                this.customerList.add((Customer) userList.get(i));
    }


    /**
     * @return Returns shipment of customer.
     */
    public Shipment getShipment() {
        return shipment;
    }

    /**
     * Shows Customer panel.
     */
    @Override
    public void ShowPanel() {
        while (true) {
            System.out.println("1-Cargo Tracking\n2-Return Main Page");
            try {
                panelAction = inputScanner.nextInt();
            } catch (InputMismatchException x) {
                System.out.println("Wrong Input.");
            }
            inputScanner.nextLine();
            switch (panelAction) {
                case 1:
                    printCargoInformation();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Unknown command");
            }
            if (panelAction == 2)
                break;


        }
    }

    /**
     * Prints information of shipment with given shipment id.
     */
    private void printCargoInformation() {
        System.out.println("Please enter the tracking number:");
        int trackingNumber;
        try {
            trackingNumber = inputScanner.nextInt();
            inputScanner.nextLine();
            if (customerList != null)
                for (int i = 0; i < customerList.size(); i++) {
                    if (customerList.get(i).getShipment().getShipmentId() == trackingNumber)
                        customerList.get(i).getShipment().printDetails();
                }
            else
                System.out.println("Shipment doesn't exist.");
        } catch (InputMismatchException x) {
            System.out.println(x);
        }
    }

    /**
     * Changes status of shipment.
     * @param newStatus New status of shipment
     */
    public void setStatus(String newStatus) {
        shipment.setStatus(newStatus);
    }
}
