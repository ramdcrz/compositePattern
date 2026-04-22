// UniversityApp.java
public class UniversityApp {
    public static void main(String[] args) {
        // 1. Create Teachers
        Teacher t1 = new Teacher("Alice Smith", "Data Structures", 60000);
        Teacher t2 = new Teacher("Bob Jones", "Machine Learning", 75000);
        Teacher t3 = new Teacher("Carol White", "Accounting", 55000);
        
        // 2. Create Students
        Student s1 = new Student("David Doe", "ID001", 5000);
        Student s2 = new Student("Eve Adams", "ID002", 5000);
        Student s3 = new Student("Frank Castle", "ID003", 4500);
        Student s4 = new Student("Grace Lee", "ID004", 4500);

        // 3. Create Departments and assign units
        Department csDept = new Department("Department of Computer Science");
        csDept.addUnit(t1);
        csDept.addUnit(t2);
        csDept.addUnit(s1);
        csDept.addUnit(s2);

        Department accDept = new Department("Department of Accountancy");
        accDept.addUnit(t3);
        accDept.addUnit(s3);
        accDept.addUnit(s4);

        // 4. Create Sub-Colleges / Main Colleges and assign units
        College collegeOfComputing = new College("College of Computing and Information Sciences");
        collegeOfComputing.addUnit(csDept);
        // We can also add a student directly to a college
        Student s5 = new Student("Hank Pym", "ID005", 6000);
        collegeOfComputing.addUnit(s5); 

        College collegeOfBusiness = new College("College of Business Administration");
        collegeOfBusiness.addUnit(accDept);

        // 5. Create the Main University (which is essentially a high-level College composite)
        College newEraUniversity = new College("New Era University - Main Campus");
        newEraUniversity.addUnit(collegeOfComputing);
        newEraUniversity.addUnit(collegeOfBusiness);

        // --- EXECUTE REQUIREMENTS ---

        System.out.println("==================================================");
        System.out.println("          NEW ERA UNIVERSITY HIERARCHY            ");
        System.out.println("==================================================\n");
        
        // A. Display the details of the organizational structure
        newEraUniversity.displayDetails("");
        
        System.out.println("\n==================================================");
        System.out.println("                 UNIVERSITY METRICS               ");
        System.out.println("==================================================\n");

        // B. Calculate and display total number of students
        System.out.println("Total Students in University: " + newEraUniversity.getStudentCount());
        System.out.println("Total Students in College of Computing: " + collegeOfComputing.getStudentCount());

        // C. Calculate and display total budget
        System.out.println("\nTotal Budget (Net Cost) for University: $" + newEraUniversity.getBudget());
        System.out.println("Total Budget for Computer Science Dept: $" + csDept.getBudget());
    }
}