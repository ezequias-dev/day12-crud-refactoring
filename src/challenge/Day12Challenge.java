package challenge;

import java.util.Scanner;

public class Day12Challenge {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println();
            System.out.println("|------------- OPTIONS MENU -------------|");
            System.out.println("| Option 1 - Register user               |");
            System.out.println("| Option 2 - List users                  |");
            System.out.println("| Option 3 - Search user by email        |");
            System.out.println("| Option 4 - Update active status by id  |");
            System.out.println("| Option 5 - Remove user by id           |");
            System.out.println("| Option 6 - Exit                        |");
            System.out.println("|----------------------------------------|");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            if (option == 1) {
                System.out.println("\n---- REGISTER USER ----");

                System.out.print("Enter an id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter a full name: ");
                String fullName = scanner.nextLine();

                System.out.print("Enter an email: ");
                String email = scanner.nextLine();

                System.out.print("Enter a role: ");
                String role = scanner.nextLine();

                System.out.print("Enter active (true/false): ");
                boolean active = scanner.nextBoolean();

                userService.addUser(new UserRecord(id, fullName, email, role, active));

            } else if (option == 2) {
                System.out.println("\n---- LIST USERS ----");

                userService.listUsers();

            } else if (option == 3) {
                System.out.println("\n---- SEARCH USER BY EMAIL ----");

                System.out.print("Enter an email: ");
                String email = scanner.nextLine();

                UserRecord foundUser = userService.findUserByEmail(email);

                if (foundUser != null) {
                    foundUser.showUserSummary();
                } else {
                    System.out.println("Email not found.");
                }

            } else if (option == 4) {
                System.out.println("\n---- UPDATE ACTIVE BY ID ----");

                System.out.print("Enter an id: ");
                int id = scanner.nextInt();

                System.out.print("Enter a new value: ");
                boolean newValue = scanner.nextBoolean();

                userService.changeActiveById(id, newValue);

            } else if (option == 5) {
                System.out.println("\n---- REMOVE USER BY ID ----");

                System.out.print("Enter an id: ");
                int id = scanner.nextInt();

                userService.removeUserById(id);

            } else if (option == 6) {
                System.out.println("End program.");
                scanner.close();
                return;

            } else {
                System.out.println("Invalid option.");
            }
        } while (true);
    }
}