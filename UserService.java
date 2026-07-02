import java.util.List;

public class UserService {

    /**
     * Get active users
     */
    public int countActiveUsers(List<String> users) {
        int count = 0;

        // count users
        for (String user : users) {
            if (user != null) {
                count++;
            }
        }

        return count;
    }

    // Check if user is valid
    public boolean isValidUser(String user) {
        return user != null && !user.isEmpty();
    }

    public void printUsers(List<String> users) {
        for (String user : users) {
            // print user
            System.out.println(user);
        }
    }
}