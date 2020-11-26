package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.contains(student)) {
            return "Student is already in the classroom";
        }

        if (this.capacity > this.students.size()) {
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "No seats in the classroom";
        }
    }


    public String dismissStudent(Student student) {
        for (Student curent : students) {
            if (curent.equals(student)) {
                this.students.remove(student);
                return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return "Student not found";
    }


    public String getSubjectInfo(String subject) {
        StringBuilder print = new StringBuilder("Subject: ").append(subject).append(System.lineSeparator())
                .append("Students:").append(System.lineSeparator());
        boolean[] isEmpty = new boolean[1];
        isEmpty[0] = true;
        this.students.stream()
                .filter(student -> student.getBestSubject().equals(subject))
                .forEach(student -> {
                    isEmpty[0] = false;
                    print.append(student.getFirstName()).append(" ").append(student.getLastName()).append(System.lineSeparator());
                });
        if (isEmpty[0]) {
            return "No students enrolled for the subject";
        }
        return print.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream().filter(student -> student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
                .findFirst().orElseThrow();
    }

    public String getStatistics() {
        StringBuilder print = new StringBuilder("Classroom size: ").append(this.students.size()).append(System.lineSeparator());
        this.students.forEach(student -> print.append("==").append(student).append(System.lineSeparator()));
        return print.toString().trim();
    }
    //o	"Classroom size: {added_students_count}
    //   ==Student: First Name= {firstName} , Last Name= {lastName} , Best Subject= {bestSubject}
    //   ==Student: First Name= {firstName} , Last Name= {lastName} , Best Subject= {bestSubject}
    //   (…)"
}
