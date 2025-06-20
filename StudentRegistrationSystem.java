// StudentRegistrationSystem.java
// ✅ Main driver class to run the full program

import java.util.Scanner;

public class StudentRegistrationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student student = null;

        // ✅ Predefined list of courses
        Course[] availableCourses = {
            new Course("Object Oriented Programming", "SECJ2154", 1),
            new Course("Operating System", "SECR2043", 1),
            new Course("Web Programming", "SECV2223", 1),
            new Course("Software Engineering", "SECS2103", 1)
        };

        // ✅ Menu loop
        while (true) {
            System.out.println("\n--- STUDENT COURSE REGISTRATION SYSTEM ---");
            System.out.println("1. Register Undergraduate Student");
            System.out.println("2. Register Postgraduate Student");
            System.out.println("3. Show Available Courses");
            System.out.println("4. Register Course");
            System.out.println("5. View Student Info & Courses");
            System.out.println("6. Exit");
            System.out.print("Select option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    input.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String ugName = input.nextLine();
                    System.out.print("Enter matrix number: ");
                    String ugMatrix = input.nextLine();
                    System.out.print("Enter program: ");
                    String ugProgram = input.nextLine();
                    System.out.print("Enter year (e.g., Year 2): ");
                    String year = input.nextLine();
                    // ✅ Creating Undergraduate (Inheritance)
                    student = new Undergraduate(ugName, ugMatrix, ugProgram, year);
                    System.out.println("Undergraduate student registered.");
                    break;

                case 2:
                    input.nextLine();
                    System.out.print("Enter name: ");
                    String pgName = input.nextLine();
                    System.out.print("Enter matrix number: ");
                    String pgMatrix = input.nextLine();
                    System.out.print("Enter program: ");
                    String pgProgram = input.nextLine();
                    System.out.print("Enter thesis title: ");
                    String thesis = input.nextLine();
                    // ✅ Creating Postgraduate (Inheritance)
                    student = new Postgraduate(pgName, pgMatrix, pgProgram, thesis);
                    System.out.println("Postgraduate student registered.");
                    break;

                case 3:
                    System.out.println("\nAvailable Courses:");
                    for (int i = 0; i < availableCourses.length; i++) {
                        System.out.println((i + 1) + ". " + availableCourses[i]);
                    }
                    break;

                case 4:
                    if (student == null) {
                        System.out.println("Please register a student first.");
                        break;
                    }
                    System.out.print("Enter course number to register (1-" + availableCourses.length + "): ");
                    int courseNum = input.nextInt();
                    if (courseNum >= 1 && courseNum <= availableCourses.length) {
                        student.registerCourse(availableCourses[courseNum - 1]);
                    } else {
                        System.out.println("Invalid course number.");
                    }
                    break;

                case 5:
                    if (student != null) {
                        student.printAllCourses();
                        System.out.println("STUDENT TYPE   : " + student.getStudentType());
                    } else {
                        System.out.println("No student data available.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Thank you!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
