import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class keeps transportation personnel data and methods.
 */
public class TransportationPersonnel extends AbstractUser {
    private ArrayList<Customer> customerList;

    /**
     * @param username Username.
     * @param password Password.
     * @param fullName Fullname.
     * @param customerList List of customers.
     */
    public TransportationPersonnel(String username, String password, String fullName, ArrayList<Customer> customerList) {
        super(username, password, fullName);
        inputScanner = new Scanner(System.in);

        this.customerList = customerList;
    }

    /**
     * Shows panel of transportation personnel.
     */
    @Override
    public void ShowPanel() {

        while (true) {
            System.out.println("1-Enter Delivery\n2-Return Main Page");
            panelAction = inputScanner.nextInt();

            switch (panelAction) {
                case 1:
                    System.out.println("Enter the package number:");
                    int packageNumber;
                    try {
                        packageNumber = inputScanner.nextInt();
                        if (customerList != null)
                            for (int i = 0; i < customerList.size(); i++) {
                                if (customerList.get(i).getShipment().getShipmentId() == packageNumber)
                                    customerList.get(i).getShipment().setStatus("Delivered");
                            }
                        else
                            System.out.println("Shipment doesn't exist.");

                        System.out.println("Package delivered!");
                    } catch (InputMismatchException x) {
                        System.out.println("Package number invalid.");
                    }
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
}


