import java.util.*;

public class Assignment {
    private String details;
    private Map<Student, String> submissions;

    public Assignment(String details) {
        this.details = details;
        this.submissions = new HashMap<>();
    }

    public String getDetails() {
        return details;
    }

    public void submit(Student student, String submissionDetails) {
        submissions.put(student, submissionDetails);
    }

    public Map<Student, String> getSubmissions() {
        return submissions;
    }
}
