import java.util.*;

public class Classroom {
    private String name;
    private List<Student> students;
    private List<Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void listStudents() {
        System.out.println("Students in " + name + ":");
        for (Student student : students) {
            System.out.println("- " + student.getId());
        }
    }

    public void listAssignments() {
        System.out.println("Assignments for " + name + ":");
        for (Assignment assignment : assignments) {
            System.out.println("- " + assignment.getDetails());
        }
    }
}

