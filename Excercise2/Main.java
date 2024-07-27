import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Virtual Classroom Manager");
        System.out.println("Commands: add_classroom, add_student, schedule_assignment, submit_assignment, list_classrooms, list_students, list_assignments, exit");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String arguments = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "add_classroom":
                    manager.addClassroom(arguments);
                    break;
                case "add_student":
                    String[] studentArgs = arguments.split(" ");
                    if (studentArgs.length == 2) {
                        manager.addStudent(studentArgs[0], studentArgs[1]);
                    } else {
                        System.out.println("Invalid arguments. Usage: add_student [student_id] [class_name]");
                    }
                    break;
                case "schedule_assignment":
                    String[] assignmentArgs = arguments.split(" ", 2);
                    if (assignmentArgs.length == 2) {
                        manager.scheduleAssignment(assignmentArgs[0], assignmentArgs[1]);
                    } else {
                        System.out.println("Invalid arguments. Usage: schedule_assignment [class_name] [assignment_details]");
                    }
                    break;
                case "submit_assignment":
                    String[] submitArgs = arguments.split(" ", 3);
                    if (submitArgs.length == 3) {
                        manager.submitAssignment(submitArgs[0], submitArgs[1], submitArgs[2]);
                    } else {
                        System.out.println("Invalid arguments. Usage: submit_assignment [student_id] [class_name] [assignment_details]");
                    }
                    break;
                case "list_classrooms":
                    manager.listClassrooms();
                    break;
                case "list_students":
                    manager.listStudents(arguments);
                    break;
                case "list_assignments":
                    manager.listAssignments(arguments);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command. Please try again.");
            }
        }
    }
}
