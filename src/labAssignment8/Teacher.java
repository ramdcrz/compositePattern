package labAssignment8;

public class Teacher implements EducationalUnit {
    private String name;
    private String subject;
    private double salary;

    public Teacher(String name, String subject, double salary) {
        this.name = name;
        this.subject = subject;
        this.salary = salary;
    }

    @Override
    public void displayDetails(String indent) {
        System.out.println(indent + "Teacher: " + name + " | Subject: " + subject + " | Salary: $" + salary);
    }

    @Override
    public int getStudentCount() {
        return 0; // A teacher does not add to the student count
    }

    @Override
    public double getBudget() {
        return salary; // Teacher's budget footprint is their salary
    }
}