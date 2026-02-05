package menu;

import database.MemberDAO;
import model.*;

import java.util.Scanner;

public class GymMenuManager implements Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final MemberDAO dao = new MemberDAO();

    @Override
    public void start() {

        while (true) {

            printMenu();

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1 -> add(true);
                case 2 -> add(false);
                case 3 -> dao.getAllMembers().forEach(System.out::println);
                case 4 -> dao.searchByName(""); // or custom type method if you want
                case 5 -> dao.searchByName("");
                case 6 -> update();
                case 7 -> delete();
                case 8 -> searchName();
                case 9 -> searchRange();
                case 10 -> highFee();
                case 11 -> dao.polymorphismDemo();
                case 0 -> { return; }
            }
        }
    }


    private void printMenu() {

        System.out.println("""
╔════════════════════════════════════════╗
║ MAIN MENU - Week 8 (GYM SYSTEM)       ║
╚════════════════════════════════════════╝
1 Add Student
2 Add Premium
3 View All
4 View Students
5 View Premiums
6 Update
7 Delete
8 Search Name
9 Fee Range
10 High Fee
11 Polymorphism Demo
0 Exit
""");
    }


    private void add(boolean student) {

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Fee: ");
        double fee = Double.parseDouble(scanner.nextLine());

        System.out.print("Experience: ");
        int exp = Integer.parseInt(scanner.nextLine());

        Member m = student
                ? new StudentMember(0, name, fee, exp)
                : new PremiumMember(0, name, fee, exp);

        dao.addMember(m);
    }


    private void update() {

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("New Name: ");
        String name = scanner.nextLine();

        System.out.print("New Fee: ");
        double fee = Double.parseDouble(scanner.nextLine());

        System.out.print("New Exp: ");
        int exp = Integer.parseInt(scanner.nextLine());

        Member old = dao.getMemberById(id);

        if (old == null) {
            System.out.println("Not found!");
            return;
        }

        Member updated = old instanceof StudentMember
                ? new StudentMember(id, name, fee, exp)
                : new PremiumMember(id, name, fee, exp);

        dao.updateMember(updated);
    }


    private void delete() {
        System.out.print("ID: ");
        dao.deleteMember(Integer.parseInt(scanner.nextLine()));
    }


    private void searchName() {
        System.out.print("Name: ");
        dao.searchByName(scanner.nextLine());
    }


    private void searchRange() {

        System.out.print("Min: ");
        double min = Double.parseDouble(scanner.nextLine());

        System.out.print("Max: ");
        double max = Double.parseDouble(scanner.nextLine());

        dao.searchByFeeRange(min, max);
    }


    private void highFee() {

        System.out.print("Minimum: ");
        dao.getHighFeeMembers(Double.parseDouble(scanner.nextLine()));
    }
}
