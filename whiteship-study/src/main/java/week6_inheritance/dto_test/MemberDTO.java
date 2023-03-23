package week6_inheritance.dto_test;

import java.util.Objects;

public class MemberDTO {
    int id;
    String name;
    int age;

    public MemberDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return id == memberDTO.id && age == memberDTO.age && Objects.equals(name, memberDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
