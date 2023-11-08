import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RpnResolverTest {

    @Test()
    void resolve_ShouldReturn3_WhenInputIs1_2_Plus() {
        // Arrange
        String input = "1 2 +";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(3, actual, "Should have returned 3");
    }

    @Test()
    void resolve_ShouldReturn2_WhenInputIs1_2_Plus_1_Minus() {
        // Arrange
        String input = "1 2 + 1 -";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(2, actual, "Should have returned 2");
    }

    @Test()
    void resolve_ShouldReturnAnIllegalArgumentException_WhenWeHaveAtMost1OperandWithOneOperator() {
        // Arrange
        String input = "1 +";

        // Act
        // Assert
        assertThrows(IllegalArgumentException.class, () -> RpnResolver.resolve(input));
    }

    @Test()
    void resolve_ShouldReturnAnIllegalArgumentException_WhenWeHave2OperatorsThatFollowsAnOperand() {
        // Arrange
        String input = "1 + +";

        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> RpnResolver.resolve(input));

        // Assert
        assertEquals("Invalid expression", exception.getMessage());
    }
}
