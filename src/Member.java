package gym;

public class Member {

    private int memberId;
    private String name;
    private int age;
    private boolean active;
    private double balance;

    // Constructor
    public Member(int memberId, String name, int age, boolean active, double balance) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.active = active;
        this.balance = balance;
    }

    // Getters
    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public double getBalance() {
        return balance;
    }

    // Setters
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Business Logic Methods
    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean canAttendGym() {
        return active && balance >= 0;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", active=" + active +
                ", balance=" + balance +
                '}';
    }
}
