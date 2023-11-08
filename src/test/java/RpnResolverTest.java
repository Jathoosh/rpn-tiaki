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
}
