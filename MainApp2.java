import java.util.ArrayList;
import java.util.Scanner;

// Abstract base class
abstract class User {
    protected String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void printInfo(); // Polymorphism
}

// Aggregation class
class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

// Association class
class Course {
    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getDetails() {
        return code + " - " + title;
    }
}

// Abstract class for Student
abstract class Student extends User {
    protected Name name;
    protected ArrayList<Course> courseList;

    public Student(String id, Name name) {
        super(id);
        this.name = name;
        this.courseList = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        courseList.add(course);
        System.out.println("\nRegistered course: " + course.getDetails());
    }

    public void listCourses() {
        System.out.println("Courses Registered:");
        int n = 1;
        for (Course c : courseList) {
                System.out.println(n + ". " + c.getDetails());  
                n++;          
        }
    }

    @Override
    public abstract void printInfo();
}

// Undergraduate class (extends Student)
class Undergraduate extends Student {
    private String year;

    public Undergraduate(String id, Name name, String year) {
        super(id, name);
        this.year = year;
    }

    @Override
    public void printInfo() {
        System.out.println("\n[Undergraduate Student]");
        System.out.println("Matrix Number   : " + id);
        System.out.println("Name            : " + name.getFullName());
        System.out.println("Year            : " + year);
    }
}

// Postgraduate class (extends Student)
class Postgraduate extends Student {
    private String thesisTitle;

    public Postgraduate(String id, Name name, String thesisTitle) {
        super(id, name);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public void printInfo() {
        System.out.println("\n[Postgraduate Student]");
        System.out.println("Matrix Number: " + id);
        System.out.println("Name         : " + name.getFullName());
        System.out.println("Thesis Title : " + thesisTitle);
    }
}

// MAIN DRIVER CLASS
public class MainApp2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = null;

        try {
            System.out.println("\n=====================================");
            System.out.println("   WELCOME TO STUDENT REGISTRATION ");
            System.out.println("=====================================");

            System.out.println("\nSelect Student Type:");
            System.out.println("1. Undergraduate");
            System.out.println("2. Postgraduate");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            System.out.print("\nEnter Student Matrix Number: ");
            String id = sc.nextLine();

            System.out.print("Enter First Name: ");
            String fname = sc.nextLine();

            System.out.print("Enter Last Name: ");
            String lname = sc.nextLine();

            Name name = new Name(fname, lname);

            if (choice == 1) {
                System.out.print("Enter Year (e.g., Year 2): ");
                String year = sc.nextLine();
                student = new Undergraduate(id, name, year);
            } else if (choice == 2) {
                System.out.print("Enter Thesis Title: ");
                String thesis = sc.nextLine();
                student = new Postgraduate(id, name, thesis);
            } else {
                throw new IllegalArgumentException("Invalid student type selected.");
            }

            System.out.println("\n=====================================");
            System.out.println("      STUDENT PROFILE FOUNDED!");
            System.out.println("=====================================");
            student.printInfo();

            //Course registration loop
            while (true) {
                System.out.println("\nRegister a New Course");
                System.out.print("Enter Course Code: ");
                String code = sc.nextLine();

                System.out.print("Enter Course Title: ");
                String title = sc.nextLine();

                if (code.isEmpty() || title.isEmpty()) {
                    throw new IllegalArgumentException("Course code and title cannot be empty.");
                }

                Course course = new Course(code, title);
                student.registerCourse(course);

                System.out.print("Add another course? (y/n): ");
                String answer = sc.nextLine();
                if (!answer.equalsIgnoreCase("y")) {
                    break;
                }
            }

            // Final summary
            System.out.println("\n=====================================");
            System.out.println("    COURSE REGISTRATION COMPLETED");
            System.out.println("=====================================");
            student.listCourses();
            System.out.println("\nThank you for registering!");
            System.out.println("\nGood Luck. See You in Next Semester!!\n");

        } catch (Exception e) {
            System.out.println("\nERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
