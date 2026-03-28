package examples;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        userService.addUser(new SystemUser(1, "Ezequias Souza", "ezequias@email.com", true));
        userService.addUser(new SystemUser(2, "Maria Silva", "maria@email.com", false));
        userService.addUser(new SystemUser(3, "Carlos Lima", "carlos@email.com", true));

        System.out.println("----- USER LIST -----");
        userService.listUsers();

        System.out.println("----- SEARCH BY EMAIL -----");
        SystemUser foundUser = userService.findByEmail("maria@email.com");
        if (foundUser != null) {
            foundUser.showSummary();
        } else {
            System.out.println("User not found.");
        }

        System.out.println("----- REMOVE USER -----");
        boolean removed = userService.removeById(2);
        System.out.println("Removed: " + removed);

        System.out.println("----- FINAL LIST -----");
        userService.listUsers();

        System.out.println("Active users: " + userService.countActiveUsers());
    }
}