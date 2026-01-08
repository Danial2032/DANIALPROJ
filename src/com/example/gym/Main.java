package com.example.gym;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Preloaded data for demonstration
        members.add(new Member(1001, "Aibek", 400000, 5, "General"));
        members.add(new PremiumMember(2001, "Murat", 600000, 12, true));
        members.add(new StudentMember(3001, "Dana", 300000, 4, "ENU"));
        members.add(new PremiumMember(2002, "Aidar", 550000, 7, false));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addParentMember();
                case 2 -> addStudent();
                case 3 -> addPremium();
                case 4 -> viewAll();
                case 5 -> demonstratePolymorphism();
                case 6 -> viewPremiumOnly();
                case 0 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void showMenu() {
        System.out.println("========================================");
        System.out.println(" GYM MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Member (Parent)");
        System.out.println("2. Add Student Member");
        System.out.println("3. Add Premium Member");
        System.out.println("4. View All Members (Polymorphic)");
        System.out.println("5. Make All Members Work");
        System.out.println("6. View Premium Members Only");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addParentMember() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Experience: ");
        int exp = scanner.nextInt();

        members.add(new Member(id, name, fee, exp, "General"));
    }

    static void addStudent() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Experience: ");
        int exp = scanner.nextInt();
        System.out.print("University: ");
        String uni = scanner.next();

        members.add(new StudentMember(id, name, fee, exp, uni));
    }

    static void addPremium() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Experience: ");
        int exp = scanner.nextInt();
        System.out.print("Personal trainer (true/false): ");
        boolean trainer = scanner.nextBoolean();

        members.add(new PremiumMember(id, name, fee, exp, trainer));
    }

    static void viewAll() {
        System.out.println("========================================");
        System.out.println(" ALL MEMBERS (POLYMORPHISM)");
        System.out.println("========================================");

        int i = 1;
        for (Member m : members) {
            System.out.println(i++ + ". " + m.getInfo());
        }
    }

    static void demonstratePolymorphism() {
        System.out.println("========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");

        for (Member m : members) {
            m.work(); // SAME method, DIFFERENT behavior
        }

        System.out.println("✨ Same method call → different outputs");
    }

    static void viewPremiumOnly() {
        System.out.println("========================================");
        System.out.println(" PREMIUM MEMBERS ONLY");
        System.out.println("========================================");

        for (Member m : members) {
            if (m instanceof PremiumMember) { // instanceof
                PremiumMember p = (PremiumMember) m; // downcasting
                System.out.println(p.name);
                p.accessSpa();
            }
        }
    }
}
