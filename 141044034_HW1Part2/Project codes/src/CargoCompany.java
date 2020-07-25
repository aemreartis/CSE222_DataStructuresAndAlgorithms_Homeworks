import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class keeps cargo company data and methods.
 */
public class CargoCompany {
    private ArrayList<AbstractUser> userList;
    private ArrayList<Branch> branchList;
    private Scanner inputReader;
    private AbstractUser currentUser;
    private String username;
    private String password;
    private Customer generalCustomer;
    CargoCompany() {
        userList = new ArrayList<AbstractUser>();
        branchList = new ArrayList<Branch>();
        userList.add(new Administrator("admin1", "admin1", "admin",userList,branchList));
        inputReader = new Scanner(System.in);
    }

    /**
     * Starts system and shows menu.
     */
    public void StartSystem() {
        while (true) {
            String systemAction;
            System.out.println("1-Login\n2-Customer shipment check.\n3-Exit System");
            try {
                systemAction = inputReader.nextLine();
            }
            catch (InputMismatchException x){
                System.out.println("Wrong Input Type");
                systemAction="4";
            }
            if (systemAction.compareTo("1") == 0) {
                System.out.print("Automation System For Cargo Company\nUsername: ");
                try {
                    username = inputReader.nextLine();
                }
                catch (InputMismatchException x){
                    System.out.println("Wrong Input Type");
                }

                System.out.print("Password: ");
                try {
                    password = inputReader.nextLine();
                }
                catch (InputMismatchException x){
                    System.out.println("Wrong Input Type");
                }

                if (authanticationCheck()) {
                    currentUser.ShowPanel();
                } else {
                    System.out.println("\nAuthantication Failed");

                }
            }
            else if(systemAction.compareTo("2") == 0){
                generalCustomer = new Customer("generalCustomer","generalCustomer","General Customer",null ,userList);
                generalCustomer.ShowPanel();
            }
            else if(systemAction.compareTo("3") == 0){
                break;
            }
            else
                System.out.println("Wrong command");
        }
    }

    /**
     * Checks username and password
     * @return Returns true if user exists.
     */
    private boolean authanticationCheck() {
        boolean success = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().compareTo(username) == 0 && userList.get(i).getPassword().compareTo(password) == 0) {
                success = true;
                currentUser = userList.get(i);
            }
        }
        return success;
    }
}
