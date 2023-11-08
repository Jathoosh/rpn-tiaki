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
        assertEquals(3, actual);
    }

    @Test()
    void resolve_ShouldReturn2_WhenInputIs1_2_Plus_1_Minus() {
        // Arrange
        String input = "1 2 + 1 -";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(2, actual);
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

    @Test()
    void resolve_ShouldReturnNegative1Number_WhenInputIs_1_0_minus() {
        // Arrange
        String input = "1 0 -";

        // Act
        Integer actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(-1, actual);
    }

    @Test()
    void resolve_ShouldReturnAnIllegalArgumentException_WhenInputContainsAFloatNumber() {
        // Arrange
        String input = "4,2 9 +";

        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> RpnResolver.resolve(input));

        // Assert
        assertEquals("Invalid expression", exception.getMessage());
    }

    @Test()
    void resolve_ShouldReturn6_WhenInputIs2_3_Times() {
        // Arrange
        String input = "2 3 *";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(6, actual);
    }
}
