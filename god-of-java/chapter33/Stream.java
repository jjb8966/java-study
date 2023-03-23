package chapter33;

import java.util.ArrayList;
import java.util.List;

public class Stream {

    private static void printStudentNameByFor(List<StudentDTO> students) {
        System.out.println("for문으로 구현");
        for (StudentDTO student : students) {
            System.out.println(student.getName());
        }
    }

    private static void printStudentNameByStream(List<StudentDTO> students) {
        System.out.println("stream으로 구현");
        students.stream().forEach(student -> System.out.println(student.getName()));
    }

    public static void main(String[] args) {
        List<StudentDTO> students = new ArrayList<>();

        students.add(new StudentDTO("aaa",10, 100));
        students.add(new StudentDTO("bbb",15, 70));
        students.add(new StudentDTO("ccc",20, 80));

        printStudentNameByFor(students);
        printStudentNameByStream(students);
    }
}
