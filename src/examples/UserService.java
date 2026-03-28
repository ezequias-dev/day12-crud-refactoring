package examples;

import java.util.ArrayList;

public class UserService {
    private ArrayList<SystemUser> users = new ArrayList<>();

    public void addUser(SystemUser user) {
        users.add(user);
    }

    public void listUsers() {
        for (SystemUser user : users) {
            user.showSummary();
        }
    }

    public SystemUser findByEmail(String email) {
        for (SystemUser user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public SystemUser findById(int id) {
        for (SystemUser user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean removeById(int id) {
        SystemUser foundUser = findById(id);

        if (foundUser != null) {
            users.remove(foundUser);
            return true;
        }

        return false;
    }

    public int countActiveUsers() {
        int total = 0;

        for (SystemUser user : users) {
            if (user.isActive()) {
                total++;
            }
        }

        return total;
    }
}