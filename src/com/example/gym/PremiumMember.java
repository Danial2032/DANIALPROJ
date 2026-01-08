package com.example.gym;

public class PremiumMember extends Member {
    private boolean personalTrainer;

    public PremiumMember(int id, String name, double fee, int experience, boolean personalTrainer) {
        super(id, name, fee, experience, "Premium");
        this.personalTrainer = personalTrainer;
    }

    @Override
    public void work() {
        System.out.println("Premium member " + name + " is training with advanced equipment.");
    }

    @Override
    public String getRole() {
        return "Premium Member";
    }

    public void accessSpa() {
        System.out.println(name + " is relaxing in the spa");
    }

    public boolean hasTrainer() {
        return personalTrainer;
    }
}
