import java.util.ArrayList;
import java.util.Scanner;

// Abstract Superclass: User
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

// Aggregation Class: Name
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

// Association Class: Course
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

// Abstract Class: Student (extends User)
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
        System.out.println("\nCourses Registered:");
        for (Course c : courseList) {
            System.out.println("- " + c.getDetails());
        }
    }

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
    public abstract void printInfo(); // Must be implemented by subclasses
}

// Subclass: Undergraduate (extends Student)
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

// Subclass: Postgraduate (extends Student)
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

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = null;

        try {
            //Student Registration
            System.out.println("=====================================");
            System.out.println(" STUDENT COURSE REGISTRATION SYSTEM ");
            System.out.println("=====================================");
            int type;
            while (true) {
                System.out.println("1. Undergraduate");
                System.out.println("2. Postgraduate");
                System.out.print("\nSelect student type: ");
                String input = sc.nextLine().trim();

                if (input.equals("1") || input.equals("2")) {
                    type = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Invalid student type. Please enter 1 or 2.");
                }
            }

            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter First Name: ");
            String fname = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String lname = sc.nextLine();
            Name name = new Name(fname, lname);

            if (type == 1) {
                String year;
                while (true) {
                    System.out.print("Enter Year (Year 1 / Year 2 / Year 3): ");
                    year = sc.nextLine().trim();

                    if (year.equalsIgnoreCase("Year 1") ||
                        year.equalsIgnoreCase("Year 2") ||
                        year.equalsIgnoreCase("Year 3")) {
                        break; // valid input, exit loop
                    }
                    System.out.println("Only Year 1 to Year 3 students can register courses. Please try again.");
                }
                student = new Undergraduate(id, name, year);
            } else if (type == 2) {
                System.out.print("Enter Thesis Title: ");
                String thesis = sc.nextLine();
                student = new Postgraduate(id, name, thesis);
            } else {
                throw new IllegalArgumentException("Invalid student type selected.");
            }

            //Main Menu
            while (true) {
                System.out.println("\n=====================================");
                System.out.println("              MAIN MENU              ");
                System.out.println("=====================================");
                System.out.println("1. Register a Course");
                System.out.println("2. List Registered Courses");
                System.out.println("3. Drop a Course");
                System.out.println("4. View Student Info");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");
                int menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 1:
                        System.out.print("Enter Course Code: ");
                        String code = sc.nextLine();
                        System.out.print("Enter Course Title: ");
                        String title = sc.nextLine();
                        if (code.isEmpty() || title.isEmpty()) {
                            throw new IllegalArgumentException("Course code and title cannot be empty.");
                        }
                        Course course = new Course(code, title);
                        student.registerCourse(course);
                        break;

                    case 2:
                        student.listCourses();
                        break;

                    case 3:
                        System.out.println("\nRegistered Courses:");
                        student.listCourses(); // ✅ Show list before asking

                        if (student.courseList.isEmpty()) {
                            break; // Exit early if no course to drop
                        }

                        System.out.print("Enter Course Code to Drop: ");
                        String dropCode = sc.nextLine();
                        student.dropCourse(dropCode);
                        break;

                    case 4:
                        student.printInfo();
                        student.listCourses();
                        break;

                    case 5:
                        System.out.println("\nThank you for using the system. Goodbye!");
                        return;

                    default:
                        System.out.println("Invalid option selected.");
                }
            }

        } catch (Exception e) {
            System.out.println("\nERROR: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
