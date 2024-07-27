import java.util.*;

public class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        this.classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        if (!classrooms.containsKey(className)) {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        } else {
            System.out.println("Classroom " + className + " already exists.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Student student = new Student(studentId);
            classroom.addStudent(student);
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            Assignment assignment = new Assignment(assignmentDetails);
            classroom.addAssignment(assignment);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String submissionDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            for (Student student : classroom.getStudents()) {
                if (student.getId().equals(studentId)) {
                    for (Assignment assignment : classroom.getAssignments()) {
                        assignment.submit(student, submissionDetails);
                        System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
                        return;
                    }
                }
            }
            System.out.println("Student " + studentId + " not found in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listClassrooms() {
        System.out.println("Classrooms:");
        for (String className : classrooms.keySet()) {
            System.out.println("- " + className);
        }
    }

    public void listStudents(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listStudents();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void listAssignments(String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.listAssignments();
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }
}
