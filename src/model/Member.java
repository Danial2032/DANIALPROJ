package model;

import exception.InvalidInputException;

public abstract class Member {

    protected int id;
    protected String name;
    protected double fee;
    protected int experience;
    protected String membershipType;

    public Member(int id, String name, double fee, int experience, String membershipType)
            throws InvalidInputException {
        setId(id);
        setName(name);
        setFee(fee);
        setExperience(experience);
        this.membershipType = membershipType;
    }

    // ABSTRACT METHOD
    public abstract void work();

    public abstract String getRole();

    // SETTERS WITH EXCEPTIONS
    public void setId(int id) throws InvalidInputException {
        if (id <= 0)
            throw new InvalidInputException("ID must be positive");
        this.id = id;
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Name cannot be empty");
        this.name = name;
    }

    public void setFee(double fee) throws InvalidInputException {
        if (fee <= 0)
            throw new InvalidInputException("Fee must be positive");
        this.fee = fee;
    }

    public void setExperience(int experience) throws InvalidInputException {
        if (experience < 0)
            throw new InvalidInputException("Experience cannot be negative");
        this.experience = experience;
    }
}
