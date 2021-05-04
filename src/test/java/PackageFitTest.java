import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import com.company.Storage;
import com.company.Package;
import com.company.Column;

public class PackageFitTest {
    private Storage storage;

    @BeforeEach
    public void setup(){
        storage = new Storage(5,5);
        storage.columns.add(new Column(3,2));
    }

    @Test
    @DisplayName("Package fits in place")
    public void testPacketFit() {
        // Arrange
        Package pack = new Package(3,2,1);
        // Act & Assert
        assertTrue(storage.fit(pack, 3, 2), "The package should fit in the storage");
    }

    @Test
    @DisplayName("Package doesn't fit in place because it sticks out of storage")
    public void testPacketDoesntFit_StickingOut() {
        // Arrange
        Package pack = new Package(3,1,1);
        // Act & Assert
        assertFalse(storage.fit(pack, 2, 3), "The package shouldn't fit in place");
    }

    @Test
    @DisplayName("Package doesn't fit in place due to the the column")
    public void testPacketDoesntFit_Column() {
        // Arrange
        Package pack = new Package(2,2,1);
        // Act & Assert
        assertFalse(storage.fit(pack, 2, 1), "The package shouldn't fit in place");
    }

    @Test
    @DisplayName("Package doesn't fit in place due to another package")
    public void testPacketDoesntFit_AnotherPackege() {
        // Arrange
        Package pack = new Package(3,2,1);
        storage.reserved[1][3] = 1;
        // Act & Assert
        assertFalse(storage.fit(pack, 0, 2), "The package shouldn't fit in place");
    }
}