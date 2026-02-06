package model;

public abstract class Member {

    protected int id;
    protected String name;
    protected double fee;
    protected int experience;

    public Member(int id, String name, double fee, int experience) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.experience = experience;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getFee() { return fee; }
    public int getExperience() { return experience; }

    public abstract String getType();



    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Fee: " + fee +
                " | Experience: " + experience +
                " | Type: " + getType();
    }
}
