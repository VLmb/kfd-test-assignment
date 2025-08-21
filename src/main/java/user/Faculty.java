package user;

public class Faculty extends User {

    private String university;

    public Faculty(String firstName, String lastName, String email, String university) {
        super(firstName, lastName, email);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public int getMaxBooks() {
        return 5;
    }

    @Override
    public int getMaxDays() {
        return 30;
    }

    @Override
    public double getDailyFine() {
        return 0.1;
    }

    @Override
    public String toString() {
        return "Faculty: " +
                " id='" + super.getUserId() + '\'' +
                ", university='" + university + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", email='" + super.getEmail() + '\'';
    }
}
