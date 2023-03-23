package chapter33;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFilterMethod {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<StudentDTO> students = Arrays.asList(new StudentDTO("a", 10, 50), new StudentDTO("b", 15, 70), new StudentDTO("c", 20, 100));

        System.out.println("<map 메소드를 이용한 정수 데이터 변환>");

        numbers.stream()
                .map(number -> number * 3)
                .forEach(System.out::println);
            // = forEach(number -> System.out.println(number));

        System.out.println("<map 메소드를 이용해 학생의 이름만 리스트로 구성>");

        List<String> studentNames = students.stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());

        studentNames.stream()
                .forEach(System.out::println);

        System.out.println("<나이가 12살이 넘는 학생의 점수를 배열로 구성>");

       int[] scores = students.stream()
                .filter(student -> student.getAge() > 12)
                .mapToInt(StudentDTO::getScore)
                .toArray();

       Arrays.stream(scores)
               .forEach(System.out::println);
    }
}
