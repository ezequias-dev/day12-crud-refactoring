package challenge;

import java.util.ArrayList;

public class UserService {
    private final ArrayList<UserRecord> users = new ArrayList<>();

    public void addUser(UserRecord user) {
        if (user == null) {
            System.out.println("User cannot be null.");
            return;
        }

        if (!user.isValidUser()) {
            System.out.println("Invalid user data.");
            return;
        }

        if (user.getId() < 1) {
            System.out.println("Id must be greater than zero.");
            return;
        }

        if (findUserById(user.getId()) != null) {
            System.out.println("Duplicate id. User not added.");
            return;
        }

        if (findUserByEmail(user.getEmail()) != null) {
            System.out.println("Duplicate email. User not added.");
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

        email = email.trim();

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
        UserRecord user = findUserById(id);

        if (user == null) {
            System.out.println("Id not found.");
            return;
        }

        user.setActive(newValue);
        System.out.println("Active updated.");
    }

    public void removeUserById(int id) {
        UserRecord user = findUserById(id);

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        users.remove(user);
        System.out.println("User successfully removed.");
    }

    public int countValidUsers() {
        int validUsers = 0;

        for (UserRecord user : users) {
            if (user.isValidUser()) {
                validUsers++;
            }
        }

        return validUsers;
    }

    public int countActiveUsers() {
        int activeUsers = 0;

        for (UserRecord user : users) {
            if (user.isActive()) {
                activeUsers++;
            }
        }

        return activeUsers;
    }

    public int getTotalUsers() {
        return users.size();
    }
}