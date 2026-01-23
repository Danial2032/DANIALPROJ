package model;

import exception.InvalidInputException;

public class StudentMember extends Member {

    private String university;

    public StudentMember(int id, String name, double fee, int experience, String university)
            throws InvalidInputException {
        super(id, name, fee, experience, "Student");
        this.university = university;
    }

    @Override
    public void work() {
        System.out.println("Student " + name + " is doing budget-friendly workouts.");
    }

    @Override
    public String getRole() {
        return "Student Member";
    }

    public void showDiscount() {
        System.out.println("Student discount applied.");
    }
}

