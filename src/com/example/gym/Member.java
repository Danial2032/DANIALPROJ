package com.example.gym;

public class Member {
    protected int id;
    protected String name;
    protected double fee;
    protected int experience;
    protected String membershipType;

    public Member(int id, String name, double fee, int experience, String membershipType) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.experience = experience;
        this.membershipType = membershipType;
    }

    public void work() {
        System.out.println(name + " is training at the gym.");
    }

    public String getInfo() {
        return "[Member] " + name +
                " (ID: " + id +
                ", Fee: " + fee +
                " KZT, Experience: " + experience + " years)";
    }

    public String getRole() {
        return "Gym Member";
    }
}
