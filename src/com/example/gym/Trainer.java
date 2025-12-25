package com.example.gym;

public class Trainer {

    // 1. PRIVATE FIELDS
    private int trainerId;
    private String name;
    private String specialization;
    private int experienceYears;

    // 2. CONSTRUCTOR WITH PARAMETERS
    public Trainer(int trainerId, String name, String specialization, int experienceYears) {
        this.trainerId = trainerId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    // 3. DEFAULT CONSTRUCTOR
    public Trainer() {
        this.trainerId = 0;
        this.name = "Unknown Trainer";
        this.specialization = "General";
        this.experienceYears = 0;
    }

    // 4. GETTERS
    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // 5. SETTERS
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    // 6. ADDITIONAL METHODS
    public boolean isSeniorTrainer() {
        return experienceYears >= 5;
    }

    public void addExperience(int years) {
        experienceYears += years;
    }

    // 7. toString()
    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                '}';
    }
}