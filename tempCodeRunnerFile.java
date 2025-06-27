import java.util.ArrayList;
import java.util.Scanner;

// Package not included, works standalone

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

    public String getCode() {
        return code;
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
        System.out.println("Registered course: " + course.getDetails());
    }

    public void listCourses() {
        if (courseList.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }
        System.out.println("Courses Registered:");
        for (Course c : courseList) {
            System.out.println("- " + c.getDetails());
        }
    }

    // ✅ New Drop Course Module
    public void dropCourse(String code) {
        boolean removed = false;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getCode().equalsIgnoreCase(code)) {
                System.out.println("Dropped course: " + courseList.get(i).getDetails());
                courseList.remove(i);
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("No course found with code: " + code);
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
        System.out.println("ID   : " + id);
        System.out.println("Name : " + name.getFullName());
        System.out.println("Year : " + year);
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
        System.out.println("ID           : " + id);
        System.out.println("Name         : " + name.getFullName());
        System.out.println("Thesis Title : " + thesisTitle);
    }
}

// MAIN DRIVER CLASS
public class MainApp3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = null;

        try {
            // Student registration
            System.out.println("--- Student Type ---");
            System.out.println("1. Undergraduate");
            System.out.println("2. Postgraduate");
            System.out.print("Select option: ");
            int choice = Integer.parseInt(sc.nextLine());

            System.out.print("Enter ID: ");
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
                throw new IllegalArgumentException("Invalid student type.");
            }

            // Main loop for additional options
            while (true) {
                System.out.println("\n=====================================");
                System.out.println("   WELCOME TO STUDENT REGISTRATION ");
                System.out.println("=====================================");
                System.out.println("\n--- MENU ---");
                System.out.println("1. Register a Course");
                System.out.println("2. List Registered Courses");
                System.out.println("3. Drop a Course");
                System.out.println("4. View Student Info");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 1:
                        System.out.print("Enter course code: ");
                        String code = sc.nextLine();
                        System.out.print("Enter course title: ");
                        String title = sc.nextLine();

                        if (code.isEmpty() || title.isEmpty()) {
                            throw new IllegalArgumentException("Course code and title cannot be empty.");
                        }
                        System.out.println("\n=====================================");
                        System.out.println("      STUDENT PROFILE FOUNDED!");
                        System.out.println("=====================================");
                        student.printInfo();
                        Course course = new Course(code, title);
                        student.registerCourse(course);
                        break;

                    case 2:
                        student.listCourses();
                        break;

                    case 3:
                        System.out.print("Enter course code to drop: ");
                        String dropCode = sc.nextLine();
                        student.dropCourse(dropCode);
                        break;

                    case 4:
                        student.printInfo();
                        student.listCourses();
                        break;

                    case 5:
                        System.out.println("Exiting system. Thank you!");
                        return;

                    default:
                        System.out.println("Invalid option.");
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
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
