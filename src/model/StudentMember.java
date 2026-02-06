package model;

public class StudentMember extends Member {

    public StudentMember(int id, String name, double fee, int experience) {
        super(id, name, fee, experience);
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}