package challenge;

import java.util.ArrayList;

public class UserService {
    private final ArrayList<UserRecord> users = new ArrayList<>();

    public void addUser(UserRecord user) {
        if (user == null) {
            System.out.println("User cannot null.");
            return;
        }

        if (!user.isValidUser()) {
            System.out.println("Invalid user data.");
            return;
        }

        if (user.getId() < 1) {
            System.out.println("id cannot be less than one.");
            return;
        }

        users.add(user);
        System.out.println("User added successfully.");
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        for (UserRecord user : users) {
            user.showUserSummary();
        }
    }

    public UserRecord findUserByEmail(String email) {
        if (email == null) {
            return null;
        }

        for (UserRecord user : users) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }

        return null;
    }

    public UserRecord findUserById(int id) {
        if (id < 1) {
            return null;
        }

        for (UserRecord user : users) {
            if (id == user.getId()) {
                return user;
            }
        }

        return null;
    }

    public void changeActiveById(int id, boolean newValue) {
        if (id < 1) {
            return;
        }


        for (UserRecord user : users) {
            if (id == user.getId()) {
                user.setActive(newValue);
                break;
            }
        }
    }

    public void removeUserById(int id) {
        if (id < 1) {
            return;
        }

        UserRecord userToRemove = null;

        for (UserRecord user : users) {
            if (id == user.getId()) {
                userToRemove = user;
                break;
            }
        }

        if (userToRemove != null) {
            users.remove(userToRemove);
        }
    }

    public int countValidUsers() {
        int validUsers = 0;

        if (users.isEmpty()) {
            return 0;
        }

        for (UserRecord user : users) {
            if (user.isValidUser()) {
                validUsers++;
            }
        }

        return validUsers;
    }

    public int countActiveUsers() {
        int activeUsers = 0;

        if (users.isEmpty()) {
            return 0;
        }

        for (UserRecord user : users) {
            if (user.isActive()) {
                activeUsers++;
            }
        }

        return activeUsers;
    }

    public void showTotalUsers() {
        int totalUsers = 0;

        if (users.isEmpty()) {
            return;
        }

        for (int i = 0; i < users.size(); i++) {
            totalUsers++;
        }

        System.out.println("Total users: " + totalUsers);
    }
}