package user;

public class Guest extends User{

    public Guest(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    @Override
    public int getMaxBooks() {
        return 3;
    }

    @Override
    public int getMaxDays() {
        return 10;
    }

    @Override
    public double getDailyFine() {
        return 0.3;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id='" + super.getUserId() + '\'' +
                "firstName='" + super.getFirstName() + '\'' +
                "lastName='" + super.getLastName() + '\'' +
                "email='" + super.getEmail() + '\'' +
                '}';
    }
}
