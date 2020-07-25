import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class keeps Administrator user type data and methods.
 */
public class Administrator extends AbstractUser {
    ArrayList<AbstractUser> userList;
    ArrayList<Branch> branchList;

    /**
     * @param username Username
     * @param password Password
     * @param fullName Fullname
     * @param userList List of users in the system.
     * @param branchList List of branches in the system.
     */
    public Administrator(String username, String password, String fullName, ArrayList<AbstractUser> userList, ArrayList<Branch> branchList) {
        super(username, password, fullName);
        this.userList = userList;
        this.branchList = branchList;
        inputScanner = new Scanner(System.in);
    }

    /**
     * Shows Administrator panel.
     */
    @Override
    public void ShowPanel() {
        while (true) {
            System.out.println("ADMIN PANEL\n1-Add Branch\n2-Remove Branch \n3-Add Branch Employee\n4-Remove Branch Employee");
            System.out.println("5-Add Transportation Personnel\n6-Remove Transportation Personnel \n7-Return Main Page");
            try {
                panelAction = inputScanner.nextInt();
            } catch (InputMismatchException x) {
                System.out.println("Wrong input type");
                //To switch default
                panelAction = 8;
            }
            inputScanner.nextLine();

            switch (panelAction) {
                case 1:
                    addBranch();
                    break;
                case 2:
                    if (branchList.size() == 0)
                        System.out.println("No branch to remove.");
                    else {
                        removeBranch();
                    }
                    break;
                case 3:
                    if (branchList.size() == 0)
                        System.out.println("No branches to add employees.");
                    else {
                        addBranchEmployee();
                    }
                    break;
                case 4:
                    if (branchList.size() == 0)
                        System.out.println("No branches to remove employees.");
                    else {
                        removeBranchEmployee();
                    }
                    break;
                case 5:
                    if (branchList.size() == 0)
                        System.out.println("No branches.");
                    else {
                        addTransportationPersonnel();
                    }
                    break;
                case 6:
                    if (branchList.size() == 0)
                        System.out.println("No branches.");
                    else {
                        removeTransportationPersonnel();
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Unknown command");
            }
            if (panelAction == 7) {
                break;
            }
        }

    }

    /**
     * Removes transportation personnel from user list and branch list .
     */
    private void removeTransportationPersonnel() {
        int branchIDR;

        System.out.println("Remove employee from branch :");
        printList(branchList);
        try {
            branchIDR = inputScanner.nextInt();
            if (branchList.size() < branchIDR || branchIDR < 1)
                throw new InputMismatchException("Branch doesnt exist.");
            if (branchList.get(branchIDR - 1).transportationPersonnelList.size() == 0)
                System.out.println("There is no transportation personnel to remove .");
            else {
                int transportationPersonnelID;
                TransportationPersonnel oldTransportationPersonnel;
                System.out.println("Remove transportationPersonnel:");
                branchList.get(branchIDR - 1).printTransportationPersonnels();
                transportationPersonnelID = inputScanner.nextInt();

                if (branchList.get(branchIDR - 1).transportationPersonnelList.size() < transportationPersonnelID || branchList.get(branchIDR - 1).transportationPersonnelList.size() < 0)
                    throw new InputMismatchException("Transportation personnel doesn't exist.");

                oldTransportationPersonnel = branchList.get(branchIDR - 1).removeTransportationPersonnel(transportationPersonnelID - 1);
                userList.remove(oldTransportationPersonnel);
                System.out.println("Transportation personnel removed");
            }
        } catch (InputMismatchException x) {
            System.out.println(x);
        }
    }

    /**
     * Adds transportation personnel to branch and user list.
     */
    private void addTransportationPersonnel() {
        String username;
        String password;
        String fullName;
        int branchNum;
        TransportationPersonnel newTransportationPersonnel;
        System.out.println("Add transportation personnel to branch :");
        printList(branchList);

        try {
            branchNum = inputScanner.nextInt();
            inputScanner.nextLine();

            if (branchNum > branchList.size() || branchNum < 1)
                throw new InputMismatchException("Branch doesn't exist.");

            System.out.print("Username of transportation personnel:\n ");
            username = inputScanner.nextLine();
            System.out.print("Password of trasnportation personnel:\n");
            password = inputScanner.nextLine();
            System.out.print("Fullname of transportation personnel:\n");
            fullName = inputScanner.nextLine();

            newTransportationPersonnel = new TransportationPersonnel(username, password, fullName, branchList.get(branchNum-1).getCustomers());
            userList.add(newTransportationPersonnel);
            branchList.get(branchNum - 1).addTransportationPersonnel(newTransportationPersonnel);
            System.out.println("New Employee added to branch " + branchList.get(branchNum - 1).getBranchName() + " employee " + fullName);
        } catch (InputMismatchException x) {
            System.out.println(x);
        }
    }

    /**
     * Removes branch employee from user list and branch list.
     */
    private void removeBranchEmployee() {
        int branchIDR;

        System.out.println("Remove employee from branch :");
        printList(branchList);
        try {
            branchIDR = inputScanner.nextInt();
            if (branchList.size() < branchIDR || branchIDR < 1)
                throw new InputMismatchException("Branch doesnt exist.");

            if (branchList.get(branchIDR - 1).employeeList.size() == 0)
                System.out.println("There is no employees to remove.");
            else {
                int branchEmployeeID;
                BranchEmployee oldEmployee;
                System.out.println("Remove employee:");
                branchList.get(branchIDR - 1).printEmployees();
                branchEmployeeID = inputScanner.nextInt();
                if (branchList.get(branchIDR - 1).employeeList.size() < branchEmployeeID || branchList.get(branchIDR - 1).employeeList.size() < 0)
                    throw new InputMismatchException("Branch employee doesn't exist.");

                oldEmployee = branchList.get(branchIDR - 1).removeEmployee(branchEmployeeID - 1);
                userList.remove(oldEmployee);
                System.out.println("Employee removed");

            }
        } catch (InputMismatchException x) {
            System.out.println(x);
        }
    }

    /**
     * Adds branch employee to user and branch list.
     */
    private void addBranchEmployee() {
        String username;
        String password;
        String fullName;
        int branchNum;
        BranchEmployee newEmployee;
        System.out.println("Add employee to branch :");
        printList(branchList);
        try {
            branchNum = inputScanner.nextInt();
            inputScanner.nextLine();
            if (branchNum > branchList.size() || branchNum < 1)
                throw new InputMismatchException("Branch doesn't exist.");

            System.out.print("Username of employee:\n ");
            username = inputScanner.nextLine();
            System.out.print("Password of employee:\n");
            password = inputScanner.nextLine();
            System.out.print("Fullname of employee:\n");
            fullName = inputScanner.nextLine();

            newEmployee = new BranchEmployee(username, password, fullName, branchList.get(branchNum - 1), userList);
            userList.add(newEmployee);
            branchList.get(branchNum - 1).addBranchEmployee(newEmployee);
            System.out.println("New Employee added to branch " + branchList.get(branchNum - 1).getBranchName() + " employee " + fullName);
        } catch (InputMismatchException x) {
            System.out.println(x);
        }
    }


    /**
     * Adds branch to branch list.
     */
    private void addBranch() {
        System.out.print("New branch name:");
        String branchName = inputScanner.nextLine();
        branchList.add(new Branch(branchName));
        System.out.println("Branch Added");
    }

    /**
     * Removes branch from branch list.
     */
    private void removeBranch() {
        int branchID;
        System.out.println("Which branch must be removed?");
        printList(branchList);
        try {
            branchID = inputScanner.nextInt();
            if(branchList.size()<branchID || branchID< 1 )
                throw new InputMismatchException("Branch doesn't exist.");
            branchList.remove(branchID - 1);
            System.out.println("Branch Removed");
        }catch (InputMismatchException x){
            System.out.println(x);
        }

    }

    /**
     *
     * @param branchList Prints list of branches
     */
    private void printList(ArrayList<Branch> branchList) {
        for (int i = 0; i < branchList.size(); i++)
            System.out.println((i + 1) + "-" + branchList.get(i).getBranchName());
    }
}
