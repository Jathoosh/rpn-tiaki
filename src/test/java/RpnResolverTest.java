import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
