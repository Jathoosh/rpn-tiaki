import org.junit.jupiter.api.Test;
import rpn.RpnResolver;

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
        assertEquals("Not enough operands", exception.getMessage());
    }

    @Test()
    void resolve_ShouldReturnAnIllegalArgumentException_WhenWeHave2Operators() {
        // Arrange
        String input = "1 1 + +";

        // Act
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> RpnResolver.resolve(input));

        // Assert
        assertEquals("Not enough operands", exception.getMessage());
    }

    @Test()
    void resolve_ShouldReturnNegative1Number_WhenInputIs_1_0_minus() {
        // Arrange
        String input = "0 1 -";

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

    @Test()
    void resolve_ShouldReturn40_WhenInputIs5_2_Times_12_Plus_2_Minus_2_Times() {
        // Arrange
        String input = "5 2 * 12 + 2 - 2 *";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(40, actual);
    }

    @Test()
    void resolve_ShouldReturn3_WhenInput9_sqrt() {
        // Arrange
        String input = "9 sqrt";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(3, actual);
    }

    @Test()
    void resolve_ShouldIgnoreMultipleSpaces_WhenMultiplesSpacesIsPresent() {
        // Arrange
        String input = "3 8  +";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(11,actual);
    }

    @Test()
    void resolve_ShouldReturn22_When15_12_5_0_22_21_max() {
        // Arrange
        String input = "15 12 5 0 22 21 max";

        // Act
        int actual = RpnResolver.resolve(input);

        // Assert
        assertEquals(22,actual);
    }
}
