import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExample { //TODO rename this, when actual tests are done

    @Test
    @DisplayName("Example test")
    public void exampleTest() {
        assertEquals(3,3, "This should be true");
    }
}
