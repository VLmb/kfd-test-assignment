package user;

public class Student extends User {

    private String university;

    public Student(String firstName, String lastName, String email, String university) {
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
        return 4;
    }

    @Override
    public int getMaxDays() {
        return 14;
    }

    @Override
    public double getDailyFine() {
        return 0.2;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + super.getUserId() + '\'' +
                "university='" + university + '\'' +
                "firstName='" + super.getFirstName() + '\'' +
                "lastName='" + super.getLastName() + '\'' +
                "email='" + super.getEmail() + '\'' +
                '}';
    }
}
