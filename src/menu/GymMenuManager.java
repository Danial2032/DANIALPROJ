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

    private void addStudent() throws InvalidInputException {
        members.add(new StudentMember(1, "Dana", 300000, 3, "ENU"));
        System.out.println("Student member added.");
    }

    private void addPremium() throws InvalidInputException {
        members.add(new PremiumMember(2, "Aidar", 600000, 5, true));
        System.out.println("Premium member added.");
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

