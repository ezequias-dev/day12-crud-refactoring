package exercises;

import java.util.ArrayList;

class UserRecord {
    private int id;
    private String fullName;
    private boolean active;

    public UserRecord (int id, String fullName, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void showUserSummary() {
        System.out.println("Id: " + getId() + " | Name: " + getFullName() + " | Active: " + isActive());
    }
}

class UserService {
    private final ArrayList<UserRecord> users = new ArrayList<>();

    public void addUser(UserRecord user) {
        users.add(user);
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

    public UserRecord findById(int id) {
        for (UserRecord user : users) {
            if (user.getId() == id) {
               return user;
            }
        }
        return null;
    }

    public boolean changeActiveStatusById(int id, boolean active) {
        UserRecord user = findById(id);

            if (user != null) {
                user.setActive(active);
                return true;
            }

        return false;
    }
}

public class Exercise04 {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new UserRecord(1, "Ezequias Souza", true));
        userService.addUser(new UserRecord(2, "Marli Santos", true));
        userService.addUser(new UserRecord(3, "Alda Silva", false));
        userService.addUser(new UserRecord(4, "Mike Silva", false));

        System.out.println();
        System.out.println("---- LIST USERS ----");
        userService.listUsers();

        System.out.println();
        System.out.println("---- CHANGE ACTIVE STATUS BY ID ----");
        boolean update =  userService.changeActiveStatusById(2, false);

        if (update) {
            System.out.println("User status updated successfully.");
        } else {
            System.out.println("User not found.");
        }

        System.out.println();
        System.out.println("---- LIST USERS AFTER UPDATE ----");
        userService.listUsers();
    }
}