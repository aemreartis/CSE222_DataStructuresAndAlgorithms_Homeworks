import java.util.Scanner;

/**
 * Abstract class to keep user information.
 */
public class AbstractUser implements IUser {

    public AbstractUser(String username, String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    Scanner inputScanner;
    private String username;
    private String password;
    private String fullName;
    protected int panelAction;


    /**
     * User action selection menu
     */
    @Override
    public void ShowPanel() {
        System.out.println("abstract panel.");
    }


    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username sets username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return returns password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password sets password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return returns fullname
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName Sets fullname
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
