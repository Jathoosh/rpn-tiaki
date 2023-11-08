package info.dmerej;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {
    @AfterAll
    static void afterAll() {

    }

    @Test
    void itWorks() {
        var hello = new Hello();
        var actual = hello.getAnswer();
        assertEquals(42, actual);
        System.out.println();
        assertThat(actual).as("Should be less than 10 but was %d", actual).isEqualTo(41);
        Hello hello1 = new Hello();

    }

    @Test
    void itDoesNotWork() {
    }
}
