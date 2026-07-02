import java.util.List;

public class UserService {

    /**
     * Get active users
     */
    public int countActiveUsers(List<String> users) {
        int count = 0;

        // count users
        for (String user : users) {
            if (user != null && user.length() > 3) {
                count++;
            }
        }

        return count;
    }

    // Check if user is valid
    public boolean isValidUser(String user, boolean checkLength) {
        if (user == null) return false;

        if (checkLength) {
            return user.length() > 5;
        }

        return !user.isEmpty();
    }

    public void logUser(String user) {
        if (user == null) {
            System.out.println("Invalid user");
        }
    }

    public void printUsers(List<String> users) {
        for (String user : users) {
            // print user
            logUser(user);
            System.out.println(user.toUpperCase());
        }
    }
}