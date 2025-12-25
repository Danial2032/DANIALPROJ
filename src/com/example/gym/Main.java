package com.example.gym;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Gym Management System ===\n");

        // Create objects
        GymMember member1 = new GymMember(1, "John", 25, "Premium", true);
        GymMember member2 = new GymMember();

        Trainer trainer1 = new Trainer(101, "Alex", "Strength Training", 6);
        Trainer trainer2 = new Trainer();

        GymSession session1 = new GymSession(5001, "Alex", "Cardio", 75, false);

        // Display initial objects
        System.out.println("--- MEMBERS ---");
        System.out.println(member1);
        System.out.println(member2);

        System.out.println("\n--- TRAINERS ---");
        System.out.println(trainer1);
        System.out.println(trainer2);

        System.out.println("\n--- SESSION ---");
        System.out.println(session1);

        // Test getters
        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("Member name: " + member1.getName());
        System.out.println("Trainer specialization: " + trainer1.getSpecialization());
        System.out.println("Session duration: " + session1.getDurationMinutes());

        // Test setters
        System.out.println("\n--- TESTING SETTERS ---");
        member2.setName("Emma");
        member2.setMembershipType("Basic");
        member2.setActive(true);
        System.out.println(member2);

        // Test additional methods
        System.out.println("\n--- TESTING METHODS ---");
        System.out.println("Is premium member: " + member1.isPremiumMember());

        trainer2.addExperience(3);
        System.out.println("Is senior trainer: " + trainer1.isSeniorTrainer());

        session1.completeSession();
        System.out.println("Session completed: " + session1.isCompleted());

        System.out.println("\n=== Program Finished Successfully ===");
    }
}