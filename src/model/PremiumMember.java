package model;

public class PremiumMember extends Member {

    public PremiumMember(int id, String name, double fee, int experience) {
        super(id, name, fee, experience);
    }

    @Override
    public String getType() {
        return "PREMIUM";
    }
}