package pra;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
        System.out.println();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println();
        System.out.println("after all");
    }

    @Test
    void test1() {
        System.out.println("test");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    @Disabled
    void test3() {
        System.out.println("test3");
    }

}