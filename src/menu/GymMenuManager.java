package menu;

import database.MemberDAO;
import model.*;

import java.util.List;
import java.util.Scanner;

public class GymMenuManager implements Menu {

    private final Scanner sc = new Scanner(System.in);
    private final MemberDAO dao = new MemberDAO();

    @Override
    public void start() throws Exception {

        while (true) {

            System.out.println("\n===== GYM MANAGEMENT =====");
            System.out.println("1 Add Student");
            System.out.println("2 Add Premium");
            System.out.println("3 View All");
            System.out.println("4 View By ID");
            System.out.println("5 Search By Name");
            System.out.println("6 Update Member");
            System.out.println("7 Delete");
            System.out.println("0 Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> addPremium();
                case 3 -> viewAll();
                case 4 -> viewById();
                case 5 -> search();
                case 6 -> update();
                case 7 -> delete();
                case 0 -> System.exit(0);
            }
        }
    }

    private void addStudent() throws Exception {
        dao.addMember(createMember(true));
    }

    private void addPremium() throws Exception {
        dao.addMember(createMember(false));
    }

    private Member createMember(boolean student) {

        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Fee: ");
        double fee = sc.nextDouble();

        System.out.print("Experience: ");
        int exp = sc.nextInt();

        if (student) {
            return new StudentMember(0, name, fee, exp);
        } else {
            return new PremiumMember(0, name, fee, exp);
        }
    }

    private void viewAll() throws Exception {
        List<Member> list = dao.getAllMembers();
        for (Member m : list) print(m);
    }

    private void viewById() throws Exception {
        System.out.print("ID: ");
        Member m = dao.getMemberById(sc.nextInt());
        if (m != null) print(m);
    }

    private void search() throws Exception {
        sc.nextLine();
        System.out.print("Keyword: ");
        List<Member> list = dao.searchByName(sc.nextLine());
        for (Member m : list) print(m);
    }

    private void update() throws Exception {

        System.out.print("ID to update: ");
        int id = sc.nextInt();

        Member updated = createMember(true); // type set later
        updated.setId(id);

        dao.updateMember(updated);
    }

    private void delete() throws Exception {
        System.out.print("ID: ");
        dao.deleteMember(sc.nextInt());
    }

    private void print(Member m) {
        System.out.println(
                m.getId() + " | " +
                        m.getName() + " | " +
                        m.getFee() + " | " +
                        m.getExperience() + " | " +
                        m.getType());
    }
}