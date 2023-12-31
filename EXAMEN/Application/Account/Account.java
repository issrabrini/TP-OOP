package Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Account {

    protected Map<String, UserInfo> userCredentials; // Storing username, password, email, and address in memory.
    protected String username;

    public Account() {
        userCredentials = new HashMap<>();
        UserInfo adminInfo = new UserInfo("admin123", "issra@gmail.com", "1234 Main.Main St");
        userCredentials.put("admin", adminInfo);
    }

    // Class to hold user information
    protected static class UserInfo {
        private String password;
        private String email;
        private String address;

        public UserInfo(String password, String email, String address) {
            this.password = password;
            this.email = email;
            this.address = address;
        }

        // Getter methods
        public String getPassword() {
            return password;
        }

    }

    public void registerUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        this.username = username;
        String password;
        do
        {
            System.out.print("Enter password (at least 8 characters with at least one number): ");
            password = scanner.nextLine();
        } while (!isValidPassword(password));
        String email;
        do
        {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
        } while (!isValidEmail(email));
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        if (!userCredentials.containsKey(username))
        {
            UserInfo userInfo = new UserInfo(password, email, address);
            userCredentials.put(username, userInfo);
            System.out.println(" registered successfully.");
        } else
        {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private boolean isValidPassword(String password)
    {
        if (password.length() < 8)
        {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }
        if (!password.matches(".*\\d.*"))
        {
            System.out.println("Password must contain at least one number.");
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        if (email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b")) {
            return true;
        } else
        {
            System.out.println("Invalid email format. Please enter a valid email address.");
            return false;
        }
    }

    public boolean authenticateUser(String username, String password)
    {
        if (userCredentials.containsKey(username)) {
            UserInfo userInfo = userCredentials.get(username);
            return password.equals(userInfo.getPassword());
        }
        return false;
    }
    public String getUsername()
    {
        return username;
    }


}