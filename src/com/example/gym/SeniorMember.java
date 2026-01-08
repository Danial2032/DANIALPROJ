package com.example.gym;

public class SeniorMember extends Member {
    private int age;

    public SeniorMember(int id, String name, double fee, int experience, int age) {
        super(id, name, fee, experience, "Senior");
        this.age = age;
    }

    @Override
    public void work() {
        System.out.println("Senior member " + name + " is doing light yoga exercises.");
    }

    @Override
    public String getRole() {
        return "Senior Member";
    }

    public void healthCheck() {
        System.out.println("Health check completed for senior member");
    }

    public int getAge() {
        return age;
    }
}

