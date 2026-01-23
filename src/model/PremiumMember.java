package model;

import exception.InvalidInputException;

public class PremiumMember extends Member implements Trainable {

    private boolean personalTrainer;

    public PremiumMember(int id, String name, double fee, int experience, boolean personalTrainer)
            throws InvalidInputException {
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

    @Override
    public void train() {
        System.out.println(name + " is training with a personal trainer.");
    }

    public void accessSpa() {
        System.out.println(name + " is relaxing in the spa.");
    }
}

