package challenge;

import java.util.Scanner;

public class Day12Challenge {
    public static void main(String[] args) {
        do {
            UserService userService = new UserService();
            Scanner scanner = new Scanner(System.in);
            int option;

            System.out.println();
            System.out.println("|------------- OPTIONS MENU -------------|");
            System.out.println("| Option 1 - Register user               |");
            System.out.println("| Option 2 - List users                  |");
            System.out.println("| Option 3 - Search user by email        |");
            System.out.println("| Option 4 - Update active status by id  |");
            System.out.println("| Option 5 - Remove user by id           |");
            System.out.println("| Option 6 - Exit                        |");
            System.out.println("|----------------------------------------|");
            System.out.print("Chose an option: ");
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

                System.out.print("Enter an active: ");
                boolean active = scanner.nextBoolean();

                userService.addUser(new UserRecord(id, fullName, email, role, active));

            } else if (option == 2) {
                System.out.println("\n---- LIST USERS ----");

                userService.listUsers();

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