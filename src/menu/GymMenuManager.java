package menu;

import model.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class GymMenuManager implements Menu {

    private final ArrayList<Member> members = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("""
        ============================
         GYM MANAGEMENT SYSTEM
        ============================
        1. Add Student Member
        2. Add Premium Member
        3. View All Members
        4. Demonstrate Polymorphism
        0. Exit
        """);
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            try {
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> addPremium();
                    case 3 -> viewAll();
                    case 4 -> demonstratePolymorphism();
                    case 0 -> {
                        System.out.println("Exiting system...");
                        return;
                    }
                    default -> throw new InvalidInputException("Invalid menu option");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a number.");
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addStudent() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Fee: ");
            double fee = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            System.out.print("University: ");
            String university = scanner.nextLine();

            StudentMember student =
                    new StudentMember(id, name, fee, exp, university);

            members.add(student);
            System.out.println(" Student member added!");

        } catch (InvalidInputException e) {
            System.out.println(" Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }


    private void addPremium() {
        try {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Fee: ");
            double fee = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Personal trainer (true/false): ");
            boolean personalTrainer = scanner.nextBoolean();
            scanner.nextLine();

            PremiumMember premium =
                    new PremiumMember(id, name, fee, exp, personalTrainer);

            members.add(premium);
            System.out.println(" Premium member added!");

        } catch (InvalidInputException e) {
            System.out.println(" Error: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }

    private void viewAll() {
        System.out.println("\n--- ALL MEMBERS ---");
        for (Member m : members) {
            System.out.println(m.getRole());
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Member m : members) {
            m.work();
        }
    }
}

